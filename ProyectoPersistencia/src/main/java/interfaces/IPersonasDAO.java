package interfaces;

import entidadesJPA.Persona;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a la información de las personas en el sistema.
 * @author Adriana
 */
public interface IPersonasDAO {
    
    /**
     * Inserta nuevas personas en el sistema.
     */
    public void insertarPersonas();
    
    /**
     * Busca una persona por su RFC.
     * @param rfc El RFC de la persona a buscar.
     * @return La persona encontrada, o null si no se encuentra.
     */
    public Persona buscarPersonasRFC(String rfc);
    
    /**
     * Busca personas por su RFC, nombre y año de nacimiento.
     * @param rfc El RFC de la persona a buscar.
     * @param nombre El nombre de la persona a buscar.
     * @param anio El año de nacimiento de la persona a buscar.
     * @return Una lista de personas que coinciden con los criterios de búsqueda.
     */
    public List<Persona> buscarPersonas(String rfc, String nombre, int anio);
        
}
