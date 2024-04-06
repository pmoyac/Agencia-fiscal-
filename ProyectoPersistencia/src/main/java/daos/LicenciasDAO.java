package daos;

import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author adria
 */
public class LicenciasDAO implements ILicenciasDAO{
    
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void insertarLicencia(Persona persona, int vigencia, Double costo, String tipo) {
        try {
            em.getTransaction().begin();

            Licencia licencia = new Licencia();
            licencia.setVigencia(vigencia);
            licencia.setCosto(costo);
            licencia.setFecha(Calendar.getInstance());
            licencia.setPersona(persona);
            licencia.setTipoLicencia(tipo);
            
            em.persist(licencia);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally{
            em.close();
        }
    }    
    
}
