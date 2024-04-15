package daos;

import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface IAutomovilDAO {
    
    public void agregarAutomovil(Automovil auto);
    
    public List<Automovil> consultarVehiculos(Persona persona);
 
    public Automovil buscarAutoNoSerie(String noSerie);
}
