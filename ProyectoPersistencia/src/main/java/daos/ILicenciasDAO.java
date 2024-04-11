package daos;

import entidadesJPA.Persona;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author adria
 */
public interface ILicenciasDAO {

    public void insertarLicencia(Persona persona, int vigencia, Double costo, String tipo);

    public boolean validarVigencia(String rfc);

}
