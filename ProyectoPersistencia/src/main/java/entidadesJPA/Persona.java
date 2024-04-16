package entidadesJPA;

import static util.Encriptacion.desencriptarTelefono;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

/**
 * Esta clase representa una persona en el sistema.
 * @author Adriana
 */
@Entity
@Table(name="personas")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /**
     * RFC (Registro Federal de Contribuyentes) de la persona.
     */
    @Id
    @Column(name = "rfc", nullable = false, length = 13)
    private String rfc;

    /**
     * Nombres de la persona.
     */
    @Column(name = "nombres", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String nombres;
    
    /**
     * Apellido paterno de la persona.
     */
    @Column(name = "apellido_paterno", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String apellido_paterno;
    
    /**
     * Apellido materno de la persona.
     */
    @Column(name = "apellido_materno", nullable = false, length = 50, columnDefinition = "VARCHAR(50)")
    private String apellido_materno;
    
    /**
     * Teléfono de la persona.
     */
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    /**
     * Fecha de nacimiento de la persona.
     */
    @Column(name = "fecha_nacimiento", nullable = false, columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento; 
    
    /**
     * Lista de trámites asociados a la persona.
     */
    @OneToMany(mappedBy = "persona", targetEntity = Tramite.class)
    private List<Tramite> tramite;
    
    /**
     * Lista de vehículos asociados a la persona.
     */
    @OneToMany(mappedBy = "persona", targetEntity = Vehiculo.class)
    private List<Vehiculo> vehiculo;
    
    /**
     * Constructor por defecto de la clase Persona.
     */
    public Persona() {
    }

    /**
     * Constructor de la clase Persona que recibe el RFC como parámetro.
     * @param rfc El RFC de la persona.
     */
    public Persona(String rfc) {
        this.rfc = rfc;
    }
    
    /**
     * Constructor de la clase Persona.
     * @param nombres Nombres de la persona.
     * @param apellido_paterno Apellido paterno de la persona.
     * @param apellido_materno Apellido materno de la persona.
     * @param telefono Teléfono de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     */
    public Persona(String nombres, String apellido_paterno, String apellido_materno, String telefono, Calendar fechaNacimiento) {
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor de la clase Persona.
     * @param rfc El RFC de la persona.
     * @param nombres Nombres de la persona.
     * @param apellido_paterno Apellido paterno de la persona.
     * @param apellido_materno Apellido materno de la persona.
     * @param telefono Teléfono de la persona.
     * @param fechaNacimiento Fecha de nacimiento de la persona.
     */
    public Persona(String rfc, String nombres, String apellido_paterno, String apellido_materno, String telefono, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.nombres = nombres;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene la lista de vehículos asociados a la persona.
     * @return La lista de vehículos asociados a la persona.
     */
    public List<Vehiculo> getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece la lista de vehículos asociados a la persona.
     * @param vehiculo La lista de vehículos asociados a la persona.
     */
    public void setVehiculo(List<Vehiculo> vehiculo) {
        this.vehiculo = vehiculo;
    }
    
    /**
     * Obtiene la lista de trámites asociados a la persona.
     * @return La lista de trámites asociados a la persona.
     */
    public List<Tramite> getTramite() {
        return tramite;
    }

    /**
     * Establece la lista de trámites asociados a la persona.
     * @param tramite La lista de trámites asociados a la persona.
     */
    public void setTramite(List<Tramite> tramite) {
        this.tramite = tramite;
    }
    
    /**
     * Obtiene el RFC de la persona.
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC de la persona.
     * @param rfc El RFC de la persona a establecer.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Obtiene los nombres de la persona.
     * @return Los nombres de la persona.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres de la persona.
     * @param nombres Los nombres de la persona a establecer.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno de la persona.
     * @return El apellido paterno de la persona.
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * Establece el apellido paterno de la persona.
     * @param apellido_paterno El apellido paterno de la persona a establecer.
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * Obtiene el apellido materno de la persona.
     * @return El apellido materno de la persona.
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * Establece el apellido materno de la persona.
     * @param apellido_materno El apellido materno de la persona a establecer.
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * Obtiene el teléfono de la persona.
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono de la persona.
     * @param telefono El teléfono de la persona a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha de nacimiento de la persona en formato de cadena (dd/MM/yyyy).
     * @return La fecha de nacimiento de la persona en formato de cadena.
     */
    public String getFechaNacimiento() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String formatoFechaNac = dateFormat.format(fechaNacimiento.getTime());
        return formatoFechaNac;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param fechaNacimiento La fecha de nacimiento de la persona a establecer.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el teléfono desencriptado de la persona.
     * @return El teléfono desencriptado de la persona.
     */
    public String getTelefonoDesencriptado() {
        return desencriptarTelefono(telefono);
    }
    
    /**
     * Devuelve una representación de cadena de la persona.
     * @return Una cadena que representa a la persona.
     */
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
