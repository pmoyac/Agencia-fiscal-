package dto;

import daos.IPersonasDAO;
import daos.PersonasDAO;
import daos.PlacasDAO;
import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import negocio.IRegistroPlacasBO;

/**
 *
 * @author Pedro
 */
public class RegistroPlacasBO implements IRegistroPlacasBO{
    IPersonasDAO per = new PersonasDAO();

    @Override
    public void registrarPlacaBO(Placa placa, String rfc) {
        PlacasDAO placaDao = new PlacasDAO();
        Automovil  a = new Automovil();
        Persona persona = per.buscarPersonasRFC(rfc);
        a = placa.getAutomovil();
        placaDao.agregarPlaca(placa);
    }
    
}
