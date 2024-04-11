/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidadesJPA.Automovil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author r
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
    
}
