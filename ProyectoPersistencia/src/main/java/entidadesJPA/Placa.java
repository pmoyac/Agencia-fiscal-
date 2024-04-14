package entidadesJPA;

import java.util.Calendar;
import java.util.Random;
import javax.persistence.*;

/**
 *
 * @author adria
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_tramite_placa")
@DiscriminatorValue("Placa")
@Table(name = "placas")
public class Placa extends Tramite {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "no_placa", nullable = false, unique = true)
    private String no_placa;

    @PrePersist
    public void generarNoPlaca() {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            sb.append(letras.charAt(random.nextInt(letras.length())));
        }

        int numero = random.nextInt(1000);
        String numeroStr = String.format("%03d", numero);

        this.no_placa = sb.toString() + "-" + numeroStr;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_recepcion")
    private Calendar fecha_recepcion;
    
    @Column(name = "estado", nullable = false)
    private String estado;
    
    @ManyToOne
    @JoinColumn(name = "id_automovil", nullable = false)
    private Automovil automovil;

    public Placa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo_placa() {
        return no_placa;
    }

    public void setNo_placa(String no_placa) {
        this.no_placa = no_placa;
    }

    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Placa{");
        sb.append("id=").append(id);
        sb.append(", no_placa=").append(no_placa);
        sb.append(", fecha_recepcion=").append(fecha_recepcion);
        sb.append(", estado=").append(estado);
        sb.append(", automovil=").append(automovil);
        sb.append('}');
        return sb.toString();
    }
    
}
