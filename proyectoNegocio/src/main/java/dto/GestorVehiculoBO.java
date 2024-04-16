package dto;

import daos.AutomovilesDAO;
import interfaces.IAutomovilDAO;
import interfaces.IPlacasDAO;
import daos.PlacasDAO;
import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IGestorVehiculosBO;

/**
 *
 * @author Pedro
 * Clase que implementa la interfaz IGestorVehiculosBO para gestionar vehículos.
 */
public class GestorVehiculoBO implements IGestorVehiculosBO {

    private final IPlacasDAO placaDAO;
    private final IAutomovilDAO autoDAO;

    /**
     * Constructor de la clase GestorVehiculoBO.
     * Inicializa los objetos de acceso a datos para placas y automóviles.
     */
    public GestorVehiculoBO() {
        this.placaDAO = new PlacasDAO();
        this.autoDAO = new AutomovilesDAO();
    }

    /**
     * Agrega un automóvil a la base de datos.
     *
     * @param auto El automóvil a agregar.
     */
    @Override
    public void agregarVehiculo(Automovil auto) {
        try {
            autoDAO.agregarAutomovil(auto);
        } catch (Exception e) {
            Logger.getLogger(GestorVehiculoBO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Obtiene la lista de vehículos asociados a una persona.
     *
     * @param persona La persona de la cual se desean obtener los vehículos.
     * @return Una lista de automóviles asociados a la persona.
     */
    @Override
    public List<Automovil> obtenerVehiculos(Persona persona) {
        try {
            return autoDAO.consultarVehiculos(persona);
        } catch (Exception e) {
            Logger.getLogger(GestorVehiculoBO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    /**
     * Obtiene la lista de placas asociadas a una persona.
     *
     * @param persona La persona de la cual se desean obtener las placas.
     * @return Una lista de placas asociadas a la persona.
     */
    @Override
    public List<Placa> obtenerPlaca(Persona persona) {
        try {            
            return placaDAO.obtenerPlacas(persona);
        } catch (Exception e) {
            Logger.getLogger(GestorVehiculoBO.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}

