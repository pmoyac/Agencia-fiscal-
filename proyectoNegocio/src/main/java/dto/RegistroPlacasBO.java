package dto;

import interfaces.IPersonasDAO;
import daos.PersonasDAO;
import daos.PlacasDAO;
import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import negocio.IRegistroPlacasBO;

/**
 * Clase que implementa la interfaz IRegistroPlacasBO para registrar placas.
 * @author Pedro
 */
public class RegistroPlacasBO implements IRegistroPlacasBO {
    IPersonasDAO per = new PersonasDAO();

    /**
     * Registra una nueva placa en la base de datos.
     *
     * @param placa La placa a registrar.
     * @param rfc El RFC de la persona asociada a la placa.
     * @return El número de placa registrado.
     */
    @Override
    public String registrarPlacaBO(Placa placa, String rfc) {
        PlacasDAO placaDao = new PlacasDAO();
        Automovil  a = new Automovil();
        Persona persona = per.buscarPersonasRFC(rfc);
        a = placa.getAutomovil();
        placaDao.agregarPlaca(placa);
        return placa.getNo_placa();
    }    
}

