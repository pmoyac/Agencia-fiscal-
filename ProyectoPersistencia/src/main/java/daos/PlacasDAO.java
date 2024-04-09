/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import entidadesJPA.Placa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
            //Iniciamos la transaccion nueva.
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Placa modificarVigencia(Placa placa) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
