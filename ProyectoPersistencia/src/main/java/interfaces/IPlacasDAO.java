package interfaces;

import entidadesJPA.Persona;
import entidadesJPA.Placa;
import java.util.List;

/**
 * Interfaz que define las operaciones para acceder a la información de las placas en el sistema.
 * @author Pedro
 */
public interface IPlacasDAO {
    
    /**
     * Agrega una nueva placa al sistema.
     * @param placa La placa a agregar.
     * @return La placa agregada.
     */
    public Placa agregarPlaca(Placa placa); 
    
    /**
     * Busca una placa por su número.
     * @param numPlaca El número de placa a buscar.
     * @return La placa encontrada, o null si no se encuentra.
     */
    public Placa buscarPlaca(String numPlaca);
    
    /**
     * Modifica la vigencia de una placa en el sistema.
     * @param placa La placa a modificar.
     * @return La placa modificada, o null si no se pudo modificar.
     */
    public Placa modificarVigencia(Placa placa);
    
    /**
     * Obtiene todas las placas asociadas a una persona.
     * @param persona La persona cuyas placas se desean obtener.
     * @return Una lista de placas asociadas a la persona especificada.
     */
    public List<Placa> obtenerPlacas(Persona persona);
    
    /**
     * Valida la vigencia de una placa.
     * @param placa La placa cuya vigencia se desea validar.
     * @return true si la placa está vigente, false de lo contrario.
     */
    public boolean validarVigencia(Placa placa);
}
