package negocio;

import entidadesJPA.Placa;

/**
 * Interfaz que define el contrato para registrar placas.
 * @author Pedro
 */
public interface IRegistroPlacasBO {
    
    /**
     * Registra una nueva placa en el sistema.
     *
     * @param placa La placa a registrar.
     * @param rfc El RFC de la persona asociada a la placa.
     * @return El número de placa registrado.
     */
    public String registrarPlacaBO(Placa placa, String rfc);
}
