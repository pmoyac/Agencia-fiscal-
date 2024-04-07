package daos;

import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author adria
 */
public class LicenciasDAO implements ILicenciasDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

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

    @Override
    public boolean validarVigencia(String rfc) {
        boolean vigente = false;
        
        try {
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
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return vigente;
    }

}
