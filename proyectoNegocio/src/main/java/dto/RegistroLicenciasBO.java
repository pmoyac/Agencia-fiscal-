package dto;

import entidadesJPA.Licencia;
import entidadesJPA.Tramite;
import java.util.Calendar;
import negocio.IRegistroLicenciasBO;

/**
 *
 * @author adria
 */
public class RegistroLicenciasBO implements IRegistroLicenciasBO{

    @Override
    public void insertarLicencia(Licencia licencia) {
////        Tramite tramite = new Tramite() {};
////        tramite.setTipo("Licencia");
////        tramite.setCosto(calcularCosto(licencia)); // Implementa este método para calcular el costo
////        tramite.setFecha(Calendar.getInstance()); // Obtener la fecha actual
////        tramite.setPersona(licencia.getPersona()); // Obtener la persona de la licencia
////        long tramiteId = TramiteDAO.save(tramite); // Insertar en la tabla tramites y obtener el ID
////
////        // Insertar en la tabla licencias
////        LicenciaDAO.save(new Licencia(tramiteId, licencia.getTipoLicencia(), licencia.getVigencia()));

    }
    
}
