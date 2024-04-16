package daos;

import com.mycompany.proyectopersistencia.Filtros;
import entidadesJPA.Persona;
import entidadesJPA.Tramite;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.eclipse.persistence.exceptions.QueryException;

/**
 *
 * @author Pedro
 */
public class TramitesDAO implements ITramitesDAO{

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();
    
    @Override
    public List<Tramite> consultarTramites(Filtros filtro) {       
        String jpqlQuery = "SELECT t FROM tramites t  WHERE (:fecha_inicial IS NULL AND :fecha_final IS NULL OR t.fecha BETWEEN :fecha_inicial AND :fecha_final)";
        try {
            TypedQuery<Tramite> query = em.createQuery(jpqlQuery, Tramite.class);

//            if (filtro.getNombre_persona()!= null) {
//                query.setParameter("nombre", "%" + filtro.getNombre_persona() + "%");
//            } else {
//                query.setParameter("nombre", null);
//            }
//            
            if (filtro.getFecha_inicial() != null && filtro.getFecha_final()!= null) {
                query.setParameter("fecha_inicial", filtro.getFecha_inicial());
                query.setParameter("fecha_final", filtro.getFecha_final());
            } else {
                query.setParameter("fecha_inicial", null);
                query.setParameter("fecha_final", null);
            }

            List<Tramite> tramites = query.getResultList();

            return tramites;
        } catch (QueryException e) {
            Logger.getLogger(TramitesDAO.class.getName()).log(Level.SEVERE, "Ocurrió un error al consultar los trámites.", e);
            return null;
        } finally {
            em.close();
        }
    }
    @Override
    public List<Tramite> buscarTramites(Persona persona, TipoTramite tipo, Date fechaDesde, Date fechaHasta) {
        try {
            TypedQuery<Tramite> query = em.createQuery(
                    "select * from tramites  "
                    + "where rfc_personas =  "+persona.getRfc()                    
                    , Tramite.class);
            query.setParameter("persona", persona.getRfc());
            query.setParameter("fechaDesde", fechaDesde);
            query.setParameter("fechaHasta", fechaHasta);
            query.setParameter("tipo", tipo);        
            return query.getResultList();
        } catch (Exception e) {
            e.getMessage();
            return null;
            
        }
//        + "and t.fecha between :fechaDesde and :fechaHasta and t.Tipo = :tipo"
    }


  
}
