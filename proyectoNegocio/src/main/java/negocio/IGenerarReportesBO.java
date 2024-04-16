package negocio;

import com.mycompany.proyectopersistencia.Filtros;
import dto.ReporteTramite;
import entidadesJPA.Tramite;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface IGenerarReportesBO {
    
     public void generarReporte(List<Tramite> listaTramites);
     
     public List<ReporteTramite> obtenerTramites(Filtros filtro);
}
