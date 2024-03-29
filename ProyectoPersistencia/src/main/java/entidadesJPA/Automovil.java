package entidadesJPA;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author adria
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_vehiculo_automovil")
@Table(name="automoviles")
public class Automovil extends Vehiculo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_automovil", nullable = false)
    private String id;

    
    
}
