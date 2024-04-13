/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
