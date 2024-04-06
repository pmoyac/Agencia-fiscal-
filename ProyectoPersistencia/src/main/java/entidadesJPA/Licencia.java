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
@PrimaryKeyJoinColumn(name = "id_tramite_licencia")
@DiscriminatorValue("Licencia")
@Table(name = "licencias")
public class Licencia extends Tramite {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "vigencia", nullable = false)
    private Integer vigencia;
    
    @Column(name = "tipo", nullable = false)
    private String tipoLicencia;

    public Licencia() {
        setTipo("Licencia");
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

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
