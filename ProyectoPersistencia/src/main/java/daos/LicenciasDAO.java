package daos;

import interfaces.ILicenciasDAO;
import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * Esta clase proporciona métodos para acceder y manipular la entidad de Licencias en la base de datos.
 * @author Adriana
 */
public class LicenciasDAO implements ILicenciasDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    /**
     * Inserta una nueva licencia para una persona en la base de datos, desactivando previamente todas las licencias activas.
     *
     * @param persona La persona a la que se le asignará la licencia.
     * @param vigencia La vigencia de la licencia en años.
     * @param costo El costo de la licencia.
     * @param tipo El tipo de la licencia.
     */
    @Override
    public void insertarLicencia(Persona persona, int vigencia, Double costo, String tipo) {
        try {
            em.getTransaction().begin();

            em.createQuery("UPDATE Licencia l SET l.estado = 'Inactivo' WHERE l.persona = :persona")
                    .setParameter("persona", persona)
                    .executeUpdate();

            Licencia licencia = new Licencia();
            licencia.setVigencia(vigencia);
            licencia.setCosto(costo);
            licencia.setFecha(Calendar.getInstance());
            licencia.setPersona(persona);
            licencia.setTipoLicencia(tipo);
            licencia.setEstado("Activo");

            em.persist(licencia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     * Valida la vigencia de la licencia de un usuario dado su RFC.
     *
     * @param rfc El RFC de la persona.
     * @return true si la licencia está vigente, false si no lo está.
     */
    @Override
    public boolean validarVigencia(String rfc) {
        boolean vigente = false;

        try {
            em.getTransaction().begin();

            TypedQuery<Licencia> queryLicencia = em.createQuery("select l from Licencia l "
                    + "inner join l.persona p "
                    + "where p.rfc = :rfc "
                    + "order by l.fecha desc", Licencia.class);
            queryLicencia.setParameter("rfc", rfc);
            queryLicencia.setMaxResults(1);
            Licencia licencia = queryLicencia.getSingleResult();

            Calendar fechaVencimiento = Calendar.getInstance();
            fechaVencimiento.add(Calendar.YEAR, licencia.getVigencia());
            Calendar fechaActual = Calendar.getInstance();

            if (fechaVencimiento.after(fechaActual)) {
                vigente = true;
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }

        return vigente;
    }

    /**
     * Obtiene la lista de licencias asociadas a una persona.
     *
     * @param persona La persona de la cual se desean obtener las licencias.
     * @return Una lista de licencias asociadas a la persona.
     */
    @Override
    public List<Licencia> obtenerLicencias(Persona persona) {
        try {
            TypedQuery<Licencia> query = em.createQuery(
                    "select l from Licencia l "
                    + "where l.persona = :persona",
                    Licencia.class);
            query.setParameter("persona", persona);
            return query.getResultList();
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

}
