package dto;

import daos.AutomovilesDAO;
import daos.IAutomovilDAO;
import daos.IPlacasDAO;
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
 */
public class GestorVehiculoBO implements IGestorVehiculosBO {

    private final IPlacasDAO placaDAO;
    private final IAutomovilDAO autoDAO;

    public GestorVehiculoBO() {
        this.placaDAO = new PlacasDAO();
        this.autoDAO = new AutomovilesDAO();

    }

    @Override
    public void agregarVehiculo(Automovil auto) {
        try {
            autoDAO.agregarAutomovil(auto);
        } catch (Exception e) {
            Logger.getLogger(GestorVehiculoBO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public List<Automovil> obtenerVehiculos(Persona persona) {
        try {
//            List<Automovil> listaAutos = autoDAO.consultarVehiculos(persona);
            return autoDAO.consultarVehiculos(persona);
        } catch (Exception e) {
            Logger.getLogger(GestorVehiculoBO.class.getName()).log(Level.SEVERE, null, e);

            return null;
        }
    }

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
