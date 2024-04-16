package dto;

import com.mycompany.proyectopersistencia.Filtros;
import daos.ITramitesDAO;
import daos.TramitesDAO;
import entidadesJPA.Licencia;
import entidadesJPA.Placa;
import entidadesJPA.Tramite;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IGenerarReportesBO;

/**
 *
 * @author Pedro
 */
public class GenerarReportesBO implements IGenerarReportesBO {

    ITramitesDAO tramitesDAO = new TramitesDAO();
    static final Logger logger = Logger.getLogger(GenerarReportesBO.class.getName());

    @Override
    public void generarReporte(List<Tramite> listaTramites) {

    }

    @Override
    public List<ReporteTramite> obtenerTramites(Filtros filtro) {
        List<ReporteTramite> listTramites = new ArrayList<>();
        Filtros filtroR = new Filtros();
        filtroR.setNombre_persona(filtro.getNombre_persona());
        filtroR.setFecha_inicial(filtro.getFecha_inicial());
        filtroR.setFecha_final(filtro.getFecha_final());
        filtroR.setTipo_tramite(filtro.getTipo_tramite());
List<Tramite> tramitesBase = this.tramitesDAO.consultarTramites(filtroR);
        try {
            
            for (Tramite tm : tramitesBase) {
                StringBuilder nombreCompleto = new StringBuilder();

                nombreCompleto.append(tm.getPersona().getNombres())
                        .append(" ")
                        .append(tm.getPersona().getApellido_paterno())
                        .append(" ")
                        .append(tm.getPersona().getApellido_materno());

                String nombreCompletoStr = nombreCompleto.toString();
                System.out.println("PASO 1");
                String tipoTramite = null;
                if (tm instanceof Licencia) {
                    tipoTramite = "Licencia";
                } else if (tm instanceof Placa) {
                    tipoTramite = "Placa";
                }

                Calendar fecha = tm.getFechaCalendar();

                ReporteTramite tramiteReporte = new ReporteTramite(
                        fecha,
                        tipoTramite,
                        nombreCompletoStr,
                        tm.getCosto());
                System.out.println("PASO 2");
                if (filtro.getTipo_tramite() != null) {
                    if (tramiteReporte.getTipo().equalsIgnoreCase(filtro.getTipo_tramite())) {
                        listTramites.add(tramiteReporte);
                    }
                } else {
                    listTramites.add(tramiteReporte);
                }
                System.out.println("PASO 3");
            }
            logger.log(Level.INFO, "Se obtuvieron los tramites");
            return listTramites;
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al obtener los tramites");
            return null;
        }
    }

}
