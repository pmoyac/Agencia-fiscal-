package daos;

import entidadesJPA.Persona;
import java.util.List;

/**
 *
 * @author adria
 */
public interface IPersonasDAO {
    
    public void insertarPersonas();
    
    public Persona buscarPersonasRFC(String rfc);
    
    public List<Persona> buscarPersonas(String rfc, String nombre, int anio);
        
}
