/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import entidadesJPA.Automovil;
import entidadesJPA.Persona;
import entidadesJPA.Placa;
import java.util.List;

/**
 *
 * @author Pedro
 */
public interface IGestorVehiculosBO {
    public void agregarVehiculo(Automovil auto);
    
    public List<Automovil> obtenerVehiculos(Persona persona);
    
    public List<Placa> obtenerPlaca(Persona persona);
}
