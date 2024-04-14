package dto;
import daos.AutomovilesDAO;
import daos.IAutomovilDAO;
import daos.IPlacasDAO;
import entidadesJPA.Automovil;
import negocio.IGestorVehiculosBO;
/**
 *
 * @author Pedro
 */
public class GestorVehiculoBO implements IGestorVehiculosBO{

    private final IPlacasDAO placaDAO;
    private final IAutomovilDAO autoDAO;
    public GestorVehiculoBO() {
        this.placaDAO = null;
        this.autoDAO = new AutomovilesDAO();
        
    }

    @Override
    public void agregarVehiculo(Automovil auto) {
        autoDAO.agregarAutomovil(auto);
    }
    
}
