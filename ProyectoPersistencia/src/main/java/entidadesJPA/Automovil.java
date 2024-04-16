package entidadesJPA;

import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Esta clase representa un automóvil en el sistema.
 * @author Adriana
 */
@Entity
@PrimaryKeyJoinColumn(name = "num_serie")
@Table(name="automoviles")
public class Automovil extends Vehiculo {

    //Color del automóvil
    @Column(name = "color", nullable = false, length = 30)
    protected String color;

    //Modelo del automóvil
    @Column(name = "modelo", nullable = false, length = 50)
    protected String modelo;

    // Línea del automóvil
    @Column(name = "linea", nullable = false, length = 50)
    protected String linea;

    // Marca del automóvil
    @Column(name = "marca", nullable = false, length = 50)
    protected String marca;

    /**
     * Constructor de la clase Automovil.
     * @param color El color del automóvil.
     * @param modelo El modelo del automóvil.
     * @param linea La línea del automóvil.
     * @param marca La marca del automóvil.
     */
    public Automovil(String color, String modelo, String linea, String marca) {
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
    }

    /**
     * Constructor de la clase Automovil.
     * @param id El identificador único del automóvil.
     * @param color El color del automóvil.
     * @param modelo El modelo del automóvil.
     * @param linea La línea del automóvil.
     * @param marca La marca del automóvil.
     * @param persona La persona propietaria del automóvil.
     */
    public Automovil(String id, String color, String modelo, String linea, String marca, Persona persona) {
        super(id, persona);
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
    }
    
    /**
     * Constructor por defecto de la clase Automovil.
     */
    public Automovil() {
    }

    /**
     * Obtiene el color del automóvil.
     * @return El color del automóvil.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del automóvil.
     * @param color El color del automóvil a establecer.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene el modelo del automóvil.
     * @return El modelo del automóvil.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del automóvil.
     * @param modelo El modelo del automóvil a establecer.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obtiene la línea del automóvil.
     * @return La línea del automóvil.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del automóvil.
     * @param linea La línea del automóvil a establecer.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Obtiene la marca del automóvil.
     * @return La marca del automóvil.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del automóvil.
     * @param marca La marca del automóvil a establecer.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    /**
     * Obtiene una representación en cadena del automóvil.
     * @return Una cadena que representa al automóvil.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Automovil{");
        sb.append(", color=").append(color);
        sb.append(", modelo=").append(modelo);
        sb.append(", linea=").append(linea);
        sb.append(", marca=").append(marca);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
