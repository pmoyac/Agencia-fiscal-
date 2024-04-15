package daos;

import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Pedro
 */
public class AutomovilesDAO implements IAutomovilDAO{

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();
    

    static final Logger logger = Logger.getLogger(PlacasDAO.class.getName());
    
    /**
     * Metodo para agregar auto 
     * @param auto 
     */
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
    
    /**    
     * Metodo que devuelve una lista de los automoviles de una persona
     * @param persona
     * @return lista de automoviles
    */  
    @Override
    public List<Automovil> consultarVehiculos(Persona persona)  {
        
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Automovil> criteria = builder.createQuery(Automovil.class);
            Root<Automovil> root = criteria.from(Automovil.class);
            criteria.select(root).where(builder.and(builder.like(root.get("persona").get("rfc"), persona.getRfc())));
            TypedQuery<Automovil> query = em.createQuery(criteria);
            List<Automovil> vehiculos = query.getResultList();
            return vehiculos;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "No se pudieron consultar los Automoviles", e); 
            return null;
        } finally {
            em.close();
        }
    }

    /**
     * Metodo que busca el automovil por numero de serie
     * @param num_serie
     * @return automovil encontrado
     */
    @Override
    public Automovil buscarAutoNoSerie(String num_serie) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Automovil> cq = cb.createQuery(Automovil.class);
        Root<Automovil> root = cq.from(Automovil.class);
        List<Predicate> parametros = new ArrayList<>();
        
        if(num_serie != null){
            parametros.add(cb.equal(root.get("id"), num_serie));
        }
        
        cq.select(root).where(parametros.toArray(Predicate[]::new));
        TypedQuery<Automovil> query = em.createQuery(cq);
        
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
}
