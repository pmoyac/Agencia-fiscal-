package daos;

import entidadesJPA.Persona;

/**
 *
 * @author adria
 */
public interface IPersonasDAO {
    
    public void insertarPersonas();
    
    public Persona buscarPersonasRFC(String rfc);
        
}
