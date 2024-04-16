package entidadesJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 * Esta clase abstracta representa un vehículo en el sistema.
 * @author Adriana
 */
@Entity
@Table(name="vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Número de serie del vehículo.
     */
    @Id    
    @Column(name = "num_serie", nullable = false)
    private String id;
    
    /**
     * Propietario del vehículo.
     */
    @ManyToOne
    @JoinColumn(name = "rfc", nullable = false)
    private Persona persona;

    /**
     * Constructor por defecto de la clase Vehiculo.
     */
    public Vehiculo() {
    }

    /**
     * Constructor de la clase Vehiculo.
     * @param id Número de serie del vehículo.
     * @param persona Propietario del vehículo.
     */
    public Vehiculo(String id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }
    
    /**
     * Obtiene el número de serie del vehículo.
     * @return El número de serie del vehículo.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el número de serie del vehículo.
     * @param id El número de serie del vehículo a establecer.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el propietario del vehículo.
     * @return El propietario del vehículo.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece el propietario del vehículo.
     * @param persona El propietario del vehículo a establecer.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Devuelve una representación de cadena del vehículo.
     * @return Una cadena que representa al vehículo.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("numeroSerie=").append(id);
        sb.append(", persona=").append(persona);        
        sb.append('}');
        return sb.toString();
    }
    
}
