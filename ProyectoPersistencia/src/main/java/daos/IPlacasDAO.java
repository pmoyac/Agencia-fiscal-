/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import entidadesJPA.Placa;

/**
 *
 * @author Pedro
 */
public interface IPlacasDAO {
    /**
    * Metodo para registrar una licencia en el sistema
    * @param la placa a registrar
    * @return la placa agregada
    */
    public Placa agregarPlaca(Placa placa); 
    
    /**
    * Metodo para buscar una placa registrada
    * @param el numero de la placa a buscar
    * @return la placa encontrada
    */
    public Placa buscarPlaca(String numPlaca);
    
    
    public Placa modificarVigencia(Placa placa);
}
