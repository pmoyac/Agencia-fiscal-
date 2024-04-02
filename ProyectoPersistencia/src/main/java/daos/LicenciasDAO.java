package daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author adria
 */
public class LicenciasDAO implements ILicenciasDAO{
    
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void insertarLicencia() {
    }
    
}
