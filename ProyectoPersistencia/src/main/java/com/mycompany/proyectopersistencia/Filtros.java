/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectopersistencia;

import java.util.Calendar;

/**
 *
 * @author Pedro
 */
public class Filtros {
    private String nombre_persona;
    private Calendar fecha_inicial;
    private Calendar fecha_final;
    private String tipo_tramite;

    public Filtros(String nombre_persona, Calendar fecha_inicial, Calendar fecha_final, String tipo_tramite) {
        this.nombre_persona = nombre_persona;
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
        this.tipo_tramite = tipo_tramite;
    }

    public Filtros(Calendar fecha_inicial, Calendar fecha_final) {
        this.fecha_inicial = fecha_inicial;
        this.fecha_final = fecha_final;
    }

    public Filtros() {
    }

    public Filtros(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }
    
    

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }

    public Calendar getFecha_inicial() {
        return fecha_inicial;
    }

    public void setFecha_inicial(Calendar fecha_inicial) {
        this.fecha_inicial = fecha_inicial;
    }

    public Calendar getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Calendar fecha_final) {
        this.fecha_final = fecha_final;
    }

    public String getTipo_tramite() {
        return tipo_tramite;
    }

    public void setTipo_tramite(String tipo_tramite) {
        this.tipo_tramite = tipo_tramite;
    }
    
    
}
