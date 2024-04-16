package interfaces;

import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a la información de los automóviles en el sistema.
 * @author Adriana
 */
public interface IAutomovilDAO {
    
    /**
     * Agrega un nuevo automóvil al sistema.
     * @param auto El automóvil a agregar.
     */
    public void agregarAutomovil(Automovil auto);
    
    /**
     * Consulta los vehículos asociados a una persona.
     * @param persona La persona cuyos vehículos se desean consultar.
     * @return Una lista de automóviles asociados a la persona especificada.
     */
    public List<Automovil> consultarVehiculos(Persona persona);
 
    /**
     * Busca un automóvil por su número de serie.
     * @param noSerie El número de serie del automóvil a buscar.
     * @return El automóvil encontrado, o null si no se encuentra.
     */
    public Automovil buscarAutoNoSerie(String noSerie);
}
