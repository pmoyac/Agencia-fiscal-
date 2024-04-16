/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;


import com.mycompany.proyectopersistencia.Filtros;
import entidadesJPA.Persona;
import entidadesJPA.Tramite;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Pedro
 */
public interface ITramitesDAO {
    
    public List<Tramite> consultarTramites(Filtros filtro) ;
    public List<Tramite> buscarTramites(Persona persona, TipoTramite tipo, Date fechaDesde, Date fechaHasta);
}
