package daos;

import entidadesJPA.Automovil;

/**
 *
 * @author Pedro
 */
public interface IAutomovilDAO {
    
    public void agregarAutomovil(Automovil auto);
 
    public Automovil buscarAutoNoSerie(String noSerie);
}
