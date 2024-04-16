package negocio;

import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import java.util.List;

/**
 * Interfaz que define el contrato para gestionar vehículos.
 * @author Pedro
 */
public interface IGestorVehiculosBO {
    
    /**
     * Agrega un vehículo al sistema.
     *
     * @param auto El automóvil a agregar.
     */
    public void agregarVehiculo(Automovil auto);
    
    /**
     * Obtiene la lista de vehículos asociados a una persona.
     *
     * @param persona La persona de la cual se desean obtener los vehículos.
     * @return Una lista de automóviles asociados a la persona.
     */
    public List<Automovil> obtenerVehiculos(Persona persona);
    
    /**
     * Obtiene la lista de placas asociadas a una persona.
     *
     * @param persona La persona de la cual se desean obtener las placas.
     * @return Una lista de placas asociadas a la persona.
     */
    public List<Placa> obtenerPlaca(Persona persona);
}

