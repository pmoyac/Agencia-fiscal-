package entidadesJPA;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author adria
 */
@Entity
@Table(name="personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "RFC", nullable = false, length = 13)
    private String rfc;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    
    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellido_paterno;
    
    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellido_materno;
    
    @Column(name = "telefono", nullable = false)
    private Long telefono;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento; 
    
    @OneToMany(mappedBy = "persona", targetEntity = Licencia.class)
    private List<Licencia> licencia;
    
    public Persona() {
    }

    public Persona(String rfc) {
        this.rfc = rfc;
    }
    
    public Persona(String nombres, String apellido_paterno, String apellido_materno, Long telefono, Calendar fechaNacimiento) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String rfc, String nombres, String apellido_paterno, String apellido_materno, Long telefono, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Licencia> getLicencia() {
        return licencia;
    }

    public void setLicencia(List<Licencia> licencia) {
        this.licencia = licencia;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombres + " "+apellido_paterno + " "+apellido_materno);
        sb.append("\nTelefono: ").append(telefono);
        return sb.toString();
    }

    

    
    
}
