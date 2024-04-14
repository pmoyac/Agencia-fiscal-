package negocio;

import entidadesJPA.Placa;

/**
 *
 * @author Pedro
 */
public interface IRegistroPlacasBO {
    public String registrarPlacaBO(Placa placa, String rfc);
}
