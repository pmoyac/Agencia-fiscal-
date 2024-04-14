package entidadesJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;
//import static entidadesJPA.Vehiculo.*;

/**
 *
 * @author adria
 */
@Entity
@PrimaryKeyJoinColumn(name = "num_serie")
@Table(name="automoviles")
public class Automovil extends Vehiculo {

//    private static final long serialVersionUID = 1L;
//    @Id    
//    @Column(name = "num_serie", nullable = false)
//    private String numSerie;
    
    @Column(name = "color", nullable = false, length = 30)
    protected String color;

    @Column(name = "modelo", nullable = false, length = 50)
    protected String modelo;

    // Línea del vehículo.
    @Column(name = "linea", nullable = false, length = 50)
    protected String linea;

    // Marca del vehículo.
    @Column(name = "marca", nullable = false, length = 50)
    protected String marca;

    public Automovil(String color, String modelo, String linea, String marca) {
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
    }

    public Automovil(String id, String color, String modelo, String linea, String marca, Persona persona) {
        super(id, persona);
        this.color = color;
        this.modelo = modelo;
        this.linea = linea;
        this.marca = marca;
    }
    
    public Automovil() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Automovil{");
    //    sb.append("numeroSerie=").append(id);
        sb.append(", color=").append(color);
        sb.append(", modelo=").append(modelo);
        sb.append(", linea=").append(linea);
        sb.append(", marca=").append(marca);
    //    sb.append(", persona=").append(persona);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
