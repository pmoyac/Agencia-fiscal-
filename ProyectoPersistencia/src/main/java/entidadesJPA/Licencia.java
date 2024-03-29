package entidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
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
@Table(name = "licencias")
public class Licencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "costo", nullable = false)
    private float costo;
    
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fecha_expedicion;
    
    @Column(name = "vigencia", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar vigencia;
    
    @Column(name = "tipo", nullable = false, length = 15)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "rfc")
    public Persona persona;

    public Licencia() {
    }

    public Licencia(Long id) {
        this.id = id;
    }

    public Licencia(Long id, Float costo, Calendar fecha_expedicion, Calendar vigencia, String tipo, Persona persona) {
        this.id = id;
        this.costo = costo;
        this.fecha_expedicion = fecha_expedicion;
        this.vigencia = vigencia;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Licencia(Float costo, Calendar fecha_expedicion, Calendar vigencia, String tipo, Persona persona) {
        this.costo = costo;
        this.fecha_expedicion = fecha_expedicion;
        this.vigencia = vigencia;
        this.tipo = tipo;
        this.persona = persona;
    }

    public Licencia(Float costo, Calendar fecha_expedicion, Calendar vigencia, String tipo) {
        this.costo = costo;
        this.fecha_expedicion = fecha_expedicion;
        this.vigencia = vigencia;
        this.tipo = tipo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public Calendar getFecha_expedicion() {
        return fecha_expedicion;
    }

    public void setFecha_expedicion(Calendar fecha_expedicion) {
        this.fecha_expedicion = fecha_expedicion;
    }

    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Licencia other = (Licencia) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Licencia{" + "id=" + id + ", costo=" + costo + ", fecha_expedicion=" + fecha_expedicion + ", vigencia=" + vigencia + ", tipo=" + tipo + ", persona=" + persona + '}';
    }
    
}
