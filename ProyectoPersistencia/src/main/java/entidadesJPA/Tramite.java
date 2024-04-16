package entidadesJPA;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 * Esta clase abstracta representa un trámite en el sistema.
 * @author Adriana
 */
@Entity
@Table(name="tramites")
@DiscriminatorColumn(name = "Tipo", discriminatorType = DiscriminatorType.STRING)
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tramite implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único del trámite.
     */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    /**
     * Tipo de trámite.
     */
    @Column(name = "tipo", nullable = false)
    private String tipo;
    
    /**
     * Fecha en que se realizó el trámite.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha", nullable = false)
    private Calendar fecha;
    
    /**
     * Costo del trámite.
     */
    @Column(name = "costo", nullable = false)
    private Double costo;
    
    /**
     * Persona que realizó el trámite.
     */
    @ManyToOne
    @JoinColumn(name = "rfc_persona", nullable = false)
    private Persona persona;

    /**
     * Constructor por defecto de la clase Tramite.
     */
    public Tramite() {
    }
    
    /**
     * Obtiene el tipo de trámite.
     * @return El tipo de trámite.
     */
    public String getTipo() {
        return tipo;
    }
    
    /**
     * Establece el tipo de trámite.
     * @param tipo El tipo de trámite a establecer.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la fecha en que se realizó el trámite.
     * @return La fecha en que se realizó el trámite.
     */
    public String getFecha() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatoFecha = dateFormat.format(fecha.getTime());
        return formatoFecha;
    }

    /**
     * Establece la fecha en que se realizó el trámite.
     * @param fecha La fecha en que se realizó el trámite a establecer.
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el costo asociado al trámite.
     * @return El costo asociado al trámite.
     */
    public Double getCosto() {
        return costo;
    }

    /**
     * Establece el costo asociado al trámite.
     * @param costo El costo asociado al trámite a establecer.
     */
    public void setCosto(Double costo) {
        this.costo = costo;
    }

    /**
     * Obtiene la persona que realizó el trámite.
     * @return La persona que realizó el trámite.
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Establece la persona que realizó el trámite.
     * @param persona La persona que realizó el trámite.
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    /**
     * Obtiene el ID del trámite.
     * @return El ID del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del trámite.
     * @param id El ID del trámite a establecer.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve una representación de cadena del trámite.
     * @return Una cadena que representa al trámite.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tramite{");
        sb.append("id=").append(id);
        sb.append(", tipo=").append(tipo);
        sb.append(", fecha=").append(fecha);
        sb.append(", costo=").append(costo);
        sb.append(", persona=").append(persona);
        sb.append('}');
        return sb.toString();
    }
    
}
