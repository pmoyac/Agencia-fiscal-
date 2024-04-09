/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import daos.PlacasDAO;
import entidadesJPA.Placa;
import negocio.IRegistroPlacasBO;

/**
 *
 * @author Pedro
 */
public class RegistroPlacasBO implements IRegistroPlacasBO{

    @Override
    public void registrarPlacaBO(Placa placa) {
        PlacasDAO placaDao = new PlacasDAO();
        placaDao.agregarPlaca(placa);
    }
    
}
