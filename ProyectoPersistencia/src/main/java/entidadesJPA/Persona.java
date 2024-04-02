package entidadesJPA;

import static entidadesJPA.Encriptacion.desencriptarTelefono;
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
    @Column(name = "rfc", nullable = false, length = 13)
    private String rfc;

    @Column(name = "nombres", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String nombres;
    
    @Column(name = "apellido_paterno", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String apellido_paterno;
    
    @Column(name = "apellido_materno", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String apellido_materno;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "fecha_nacimiento", nullable = false, columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento; 
    
    @OneToMany(mappedBy = "persona", targetEntity = Tramite.class)
    private List<Tramite> tramite;
    
    @OneToMany(mappedBy = "persona", targetEntity = Vehiculo.class)
    private List<Vehiculo> vehiculo;
    
    public Persona() {
    }

    public Persona(String rfc) {
        this.rfc = rfc;
    }
    
    public Persona(String nombres, String apellido_paterno, String apellido_materno, String telefono, Calendar fechaNacimiento) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Persona(String rfc, String nombres, String apellido_paterno, String apellido_materno, String telefono, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(List<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    public List<Tramite> getTramite() {
        return tramite;
    }

    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFechaNacimiento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatoFechaNac = dateFormat.format(fechaNacimiento.getTime());
        return formatoFechaNac;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefonoDesencriptado() {
        return desencriptarTelefono(telefono);
    }
    
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatoFechaNac = dateFormat.format(fechaNacimiento.getTime());

        StringBuilder sb = new StringBuilder();
        sb.append("Nombre: ").append(nombres).append(" ").append(apellido_paterno).append(" ").append(apellido_materno);
        sb.append("\nFecha de nacimiento: ").append(formatoFechaNac);
        sb.append("\nTelefono: ").append(desencriptarTelefono(telefono));
        return sb.toString();
    }
    
}
