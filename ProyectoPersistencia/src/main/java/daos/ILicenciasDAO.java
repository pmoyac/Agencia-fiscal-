package daos;

import entidadesJPA.Persona;

/**
 *
 * @author adria
 */
public interface ILicenciasDAO {
    
    public void insertarLicencia(Persona persona, int vigencia, Double costo, String tipo);
    
}
