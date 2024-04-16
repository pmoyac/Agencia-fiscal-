package daos;

import interfaces.IPlacasDAO;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 * Esta clase proporciona métodos para acceder y manipular la entidad de Placas en la base de datos.
 * @author Pedro
 */
public class PlacasDAO implements IPlacasDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    static final Logger logger = Logger.getLogger(PlacasDAO.class.getName());
    
    /**
     * Agrega una nueva placa para un automóvil, desactivando previamente todas las placas activas asociadas al mismo automóvil.
     *
     * @param placa La placa que se desea agregar.
     * @return La placa agregada.
     */
    @Override
    public Placa agregarPlaca(Placa placa) {
        try {
            em.getTransaction().begin();

            TypedQuery<Placa> queryPlaca = em.createQuery(
                    "SELECT p FROM Placa p WHERE p.automovil = :automovil AND p.estado = 'Activa'",
                    Placa.class);
            queryPlaca.setParameter("automovil", placa.getAutomovil());
            List<Placa> placasActivas = queryPlaca.getResultList();

            for (Placa placaActiva : placasActivas) {
                placaActiva.setEstado("Inactivo");
                em.merge(placaActiva);
            }

            em.persist(placa);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.log(Level.SEVERE, "No se pudo agregar la placa", e);
        } finally {
            em.close();
        }
        return placa;
    }

    /**
     * Busca una placa en la base de datos por su número de placa.
     *
     * @param numPlaca El número de placa que se desea buscar.
     * @return La placa encontrada, o null si no se encuentra ninguna placa con el número proporcionado.
     */
    @Override
    public Placa buscarPlaca(String numPlaca) {
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
            Root<Placa> root = criteria.from(Placa.class);

            criteria.select(root).where(
                    builder.equal(root.get("no_placa"), numPlaca)
            );

            TypedQuery<Placa> query = em.createQuery(criteria);
            Placa placa = query.getSingleResult();

            if (placa != null && placa.getEstado().equals("Inactivo")) {
                JOptionPane.showMessageDialog(null, 
                        "La placa proporcionada está inactiva.", 
                        "Placa Inactiva", JOptionPane.ERROR_MESSAGE);
            }

            return placa;
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Modifica la vigencia de una placa en la base de datos.
     *
     * @param placa La placa cuya vigencia se desea modificar.
     * @return La placa con la vigencia modificada, o null si no se pudo realizar la modificación.
     */
    @Override
    public Placa modificarVigencia(Placa placa) {
        try {
            em.getTransaction().begin();

            String jpqlUpdate = "UPDATE Placa p SET p.estado = :estado, p.fecha_recepcion = :fecha WHERE p.no_placa = :numPlaca";
            Query queryUpdate = em.createQuery(jpqlUpdate);
            queryUpdate.setParameter("estado", false);
            queryUpdate.setParameter("fecha", Calendar.getInstance());
            queryUpdate.setParameter("numPlaca", placa.getNo_placa());

            int updatedCount = queryUpdate.executeUpdate();
            if (updatedCount > 0) {
                em.getTransaction().commit();
                logger.log(Level.INFO, "Se modificó el estado y la fecha de recepción de la Placa");
                return placa;
            } else {
                em.getTransaction().rollback();
                logger.log(Level.INFO, "No se modificó ninguna placa");
                return null;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            logger.log(Level.SEVERE, "Error al actualizar la placa", e);
            return null;
        }
    }

    /**
     * Obtiene la lista de placas asociadas a una persona.
     *
     * @param persona La persona de la cual se desean obtener las placas.
     * @return Una lista de placas asociadas a la persona.
     */
    @Override
    public List<Placa> obtenerPlacas(Persona persona) {
        try {
            TypedQuery<Placa> query = em.createQuery(
                    "select p from Placa p "
                    + "where p.persona = :persona",
                    Placa.class);
            query.setParameter("persona", persona);
            return query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    /**
     * Valida la vigencia de una placa.
     *
     * @param placa La placa cuya vigencia se desea validar.
     * @return true si la placa está vigente, false si no lo está.
     */
    @Override
    public boolean validarVigencia(Placa placa) {
        boolean vigente = false;

        try {
            TypedQuery<Placa> queryPlaca = em.createQuery(
                    "SELECT p FROM Placa p WHERE p.automovil = :automovil AND p.estado = 'Activa'",
                    Placa.class);
            queryPlaca.setParameter("automovil", placa.getAutomovil());
            List<Placa> placasActivas = queryPlaca.getResultList();

            for (Placa placaActiva : placasActivas) {
                if (!placaActiva.getNo_placa().equals(placa.getNo_placa())) {
                    vigente = false;
                    return vigente;
                }
            }
            vigente = true;

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al validar la vigencia de la placa", e);
        }

        return vigente;
    }


}
