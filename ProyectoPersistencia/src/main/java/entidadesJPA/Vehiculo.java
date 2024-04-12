package entidadesJPA;

import static entidadesJPA.Automovil_.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.*;

/**
 *
 * @author adria
 */
@Entity
@Table(name="vehiculos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "num_serie", nullable = false)
    private String id;
    
    @ManyToOne
    @JoinColumn(name = "rfc", nullable = false)
    private Persona persona;

    public Vehiculo() {
    }

    public Vehiculo(String id, Persona persona) {
        this.id = id;
        this.persona = persona;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("numeroSerie=").append(id);
        sb.append(", color=").append(color);
        sb.append(", modelo=").append(modelo);
        sb.append(", linea=").append(linea);
        sb.append(", marca=").append(marca);
        sb.append(", persona=").append(persona);        
        sb.append('}');
        return sb.toString();
    }
    
}
