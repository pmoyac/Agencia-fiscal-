package daos;

import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import java.util.List;

/**
 *
 * @author adria
 */
public interface ILicenciasDAO {
    
    public void insertarLicencia(Persona persona, int vigencia, Double costo, String tipo);
    
    public boolean validarVigencia(String rfc);
    
    public List<Licencia> obtenerLicencias(Persona persona);
}
