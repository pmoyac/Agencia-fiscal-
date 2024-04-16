package interfaces;

import entidadesJPA.Licencia;
import entidadesJPA.Persona;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a la información de las licencias en el sistema.
 * @author Adriana
 */
public interface ILicenciasDAO {
    
    /**
     * Inserta una nueva licencia en el sistema.
     * @param persona La persona a la que se le asignará la licencia.
     * @param vigencia La vigencia de la licencia en años.
     * @param costo El costo de la licencia.
     * @param tipo El tipo de licencia.
     */
    public void insertarLicencia(Persona persona, int vigencia, Double costo, String tipo);
    
    /**
     * Valida la vigencia de la licencia de una persona.
     * @param rfc El RFC de la persona cuya licencia se desea validar.
     * @return true si la licencia está vigente, false de lo contrario.
     */
    public boolean validarVigencia(String rfc);
    
    /**
     * Obtiene todas las licencias asociadas a una persona.
     * @param persona La persona cuyas licencias se desean obtener.
     * @return Una lista de licencias asociadas a la persona especificada.
     */
    public List<Licencia> obtenerLicencias(Persona persona);
}
