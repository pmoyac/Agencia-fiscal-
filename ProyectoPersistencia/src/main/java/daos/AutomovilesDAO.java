package daos;

import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class AutomovilesDAO implements IAutomovilDAO{

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();
    

    static final Logger logger = Logger.getLogger(PlacasDAO.class.getName());
    
    @Override
    public void agregarAutomovil(Automovil auto) {
        try {
            em.getTransaction().begin();
            em.persist(auto);
            em.getTransaction().commit();
            logger.log(Level.INFO, "Se agregó el automovil correctamente");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "error al agregar el automovil");

        } finally {
            em.close();
        }
    }
    
//    public List<Automovil> consultarVehiculos(Persona persona)  {
//        
//        try {
//            CriteriaBuilder builder = em.getCriteriaBuilder();
//            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
//            Root<Automovil> root = criteria.from(Automovil.class);
//            criteria.select(root).where(builder.and(builder.like(root.get("persona").get("rfc"), persona.getRfc())));
//            TypedQuery<Automovil> query = em.createQuery(criteria);
//            List<Automovil> vehiculos = query.getResultList();
//            return vehiculos;
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "No se pudieron consultar los vehiculos", e);            
//        } finally {
//            em.close();
//        }
//    }
    
}
