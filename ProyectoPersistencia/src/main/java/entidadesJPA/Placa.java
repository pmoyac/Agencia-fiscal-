package entidadesJPA;

import java.util.Calendar;
import java.util.Random;
import javax.persistence.*;

/**
 * Esta clase representa una placa de automóvil en el sistema 
 * @author Adriana
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_tramite_placa")
@DiscriminatorValue("Placa")
@Table(name = "placas")
public class Placa extends Tramite {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único de la placa.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    /**
     * Número de placa del automóvil.
     */
    @Column(name = "no_placa", nullable = false, unique = true)
    private String no_placa;

    /**
     * Método utilizado para generar automáticamente un número de placa único.
     */
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
    
    /**
     * Fecha de recepción de la placa.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_recepcion")
    private Calendar fecha_recepcion;
    
    /**
     * Estado de la placa (activo/inactivo, etc.).
     */
    @Column(name = "estado", nullable = false)
    private String estado;
    
    /**
     * Automóvil asociado a la placa.
     */
    @ManyToOne
    @JoinColumn(name = "id_automovil", nullable = false)
    private Automovil automovil;

    /**
     * Constructor por defecto de la clase Placa.
     */
    public Placa() {
    }

    /**
     * Obtiene el ID de la placa.
     * @return El ID de la placa.
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la placa.
     * @param id El ID de la placa a establecer.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el número de placa.
     * @return El número de placa.
     */
    public String getNo_placa() {
        return no_placa;
    }

    /**
     * Establece el número de placa.
     * @param no_placa El número de placa a establecer.
     */
    public void setNo_placa(String no_placa) {
        this.no_placa = no_placa;
    }

    /**
     * Obtiene la fecha de recepción de la placa.
     * @return La fecha de recepción de la placa.
     */
    public Calendar getFecha_recepcion() {
        return fecha_recepcion;
    }

    /**
     * Establece la fecha de recepción de la placa.
     * @param fecha_recepcion La fecha de recepción de la placa a establecer.
     */
    public void setFecha_recepcion(Calendar fecha_recepcion) {
        this.fecha_recepcion = fecha_recepcion;
    }

    /**
     * Obtiene el estado de la placa.
     * @return El estado de la placa.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la placa.
     * @param estado El estado de la placa a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Obtiene el automóvil asociado a la placa.
     * @return El automóvil asociado a la placa.
     */
    public Automovil getAutomovil() {
        return automovil;
    }
    
    /**
     * Obtiene el número de serie del automóvil asociado a la placa.
     * @return El número de serie del automóvil asociado a la placa.
     */
    public String getNoSerieAuto(){
        return automovil.getId();
    }

    /**
     * Establece el automóvil asociado a la placa.
     * @param automovil El automóvil asociado a la placa.
     */
    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }

    /**
     * Devuelve una representación de cadena de la placa.
     * @return Una cadena que representa a la placa.
     */
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
