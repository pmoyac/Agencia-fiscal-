package daos;

import entidadesJPA.Placa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class PlacasDAO implements IPlacasDAO{
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
        }finally {
            em.close();
        }
    }

    @Override
    public Placa modificarVigencia(Placa placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
