package dto;

import java.util.Calendar;

/**
 *
 * @author Pedro
 */
public class ReporteTramite {

    private Calendar fecha;   
    private String tipo;
    private String nombre;
    private double costo;

    public ReporteTramite(Calendar fecha, String tipo, String nombre, double costo) {
        this.fecha = fecha;
        this.tipo = tipo;
        this.nombre = nombre;
        this.costo = costo;
    }
          
    public ReporteTramite(Calendar fecha) {
        this.fecha = fecha;
    }

    public ReporteTramite(String tipo) {
        this.tipo = tipo;
    }

    public ReporteTramite() {
    }                

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    
}
