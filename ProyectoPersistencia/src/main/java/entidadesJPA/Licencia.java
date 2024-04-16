package entidadesJPA;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 * Esta clase representa una licencia de conducir en el sistema.
 * @author Adriana
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_tramite_licencia")
@DiscriminatorValue("Licencia")
@Table(name = "licencias")
public class Licencia extends Tramite {

    private static final long serialVersionUID = 1L;
    
    /**
     * Identificador único de la licencia.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    /**
     * Vigencia de la licencia en años.
     */
    @Column(name = "vigencia", nullable = false)
    private Integer vigencia;
    
    /**
     * Tipo de licencia (Discapacitado o Sin discapacidad).
     */
    @Column(name = "tipo", nullable = false)
    private String tipoLicencia;
    
    /**
     * Estado actual de la licencia (Activo o Inactivo).
     */
    @Column(name = "estado", nullable = false)
    private String estado;

    /**
     * Constructor por defecto de la clase Licencia.
     */
    public Licencia() {
        setTipo("Licencia");
    }

    /**
     * Obtiene el ID de la licencia.
     * @return El ID de la licencia.
     */
    @Override
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la licencia.
     * @param id El ID de la licencia a establecer.
     */
    @Override
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la vigencia de la licencia.
     * @return La vigencia de la licencia en años.
     */
    public Integer getVigencia() {
        return vigencia;
    }

    /**
     * Establece la vigencia de la licencia.
     * @param vigencia La vigencia de la licencia a establecer en años.
     */
    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Obtiene el tipo de la licencia.
     * @return El tipo de la licencia.
     */
    public String getTipoLicencia() {
        return tipoLicencia;
    }

    /**
     * Establece el tipo de la licencia.
     * @param tipoLicencia El tipo de licencia a establecer.
     */
    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    /**
     * Obtiene el estado de la licencia.
     * @return El estado actual de la licencia.
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la licencia.
     * @param estado El estado de licencia a establecer.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    /**
     * Devuelve una representación de cadena de la licencia.
     * @return Una cadena que representa la licencia.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Licencia{");
        sb.append("id=").append(id);
        sb.append(", vigencia=").append(vigencia);
        sb.append(", tipoLicencia=").append(tipoLicencia);
        sb.append('}');
        return sb.toString();
    }
}
