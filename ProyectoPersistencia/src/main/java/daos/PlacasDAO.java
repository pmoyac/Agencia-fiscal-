package daos;

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

/**
 *
 * @author Pedro
 */
public class PlacasDAO implements IPlacasDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    static final Logger logger = Logger.getLogger(PlacasDAO.class.getName());

    @Override
    public Placa agregarPlaca(Placa placa) {

        try {
            em.getTransaction().begin();
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
            return placa;
        } catch (NoResultException e) {
            logger.log(Level.INFO, "No se encontró la placa");
            return null;
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "Error al consultar la placa", e);
//            
//        } 
        } finally {
            em.close();
        }
    }

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
                String jpqlSelect = "SELECT p FROM Placa p WHERE p.numeroPlaca = :numPlaca";
                Query querySelect = em.createQuery(jpqlSelect);
                querySelect.setParameter("numPlaca", placa.getNo_placa());
                List<Placa> placasModificadas = querySelect.getResultList();
                em.getTransaction().commit();
                logger.log(Level.INFO, "Se modificó el estado y la fecha de recepción de la Placa");
                return placasModificadas.get(0);
            } else {
                logger.log(Level.INFO, "No se modificó ninguna placa");
                return null;
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al actualizar la placa", e);
            return null;
        } finally {
            em.close();
        }

    }

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

}
