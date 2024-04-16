package daos;

import interfaces.IPersonasDAO;
import static util.Encriptacion.encriptarTelefono;
import entidadesJPA.Persona;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

/**
 * Esta clase proporciona métodos para acceder y manipular la entidad de Personas en la base de datos.
 * @author Adriana
 */
public class PersonasDAO implements IPersonasDAO {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    /**
     * Inserta personas en la base de datos si no existen ya registros previos.
     */
    @Override
    public void insertarPersonas() {
        boolean personasInsertadas = false;

        try {
            // Verificar si las personas ya han sido insertadas
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
            Root<Persona> root = countQuery.from(Persona.class);
            countQuery.select(cb.count(root));
            Long count = em.createQuery(countQuery).getSingleResult();

            if (count > 0) {
                JOptionPane.showMessageDialog(null, "Las personas ya han sido insertadas anteriormente.",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                Persona persona1 = new Persona("GURA030404EG3", "Adriana", "Gutierrez", "Robles", "6448989093", new GregorianCalendar(2003, 04 - 1, 04));
                Persona persona2 = new Persona("MOCP880503JV4", "Pedro Antonio", "Moya", "Castro", "6442789903", new GregorianCalendar(1988, 05 - 1, 03));
                Persona persona3 = new Persona("NUCK040104HI8", "Kamila Noemy", "Nuñez", "Choix", "6442890063", new GregorianCalendar(2004, 01 - 1, 04));
                Persona persona4 = new Persona("PIVA040822JR2", "Alexa Maria", "Picos", "Valenzuela", "6442157463", new GregorianCalendar(2004, 8 - 1, 22));
                Persona persona5 = new Persona("MOEE040223JE6", "Esmeralda", "Molina", "Estrada", "644854321", new GregorianCalendar(2004, 02 - 1, 23));
                Persona persona6 = new Persona("BETI030131FG2", "Itza Paulina", "Bernal", "Teran", "6442846734", new GregorianCalendar(2003, 01 - 1, 31));
                Persona persona7 = new Persona("FURS030331JD3", "Suseth Alejandra", "Fuentes", "Ruiz", "6442985263", new GregorianCalendar(2003, 03 - 1, 31));
                Persona persona8 = new Persona("GUTD030818AU6", "Darian", "Gutierrez", "Torres", "6442489762", new GregorianCalendar(2003, 8 - 1, 18));
                Persona persona9 = new Persona("GIMS030605UY4", "Sandra Paola", "Giron", "Mendivil", "6441234897", new GregorianCalendar(2003, 06 - 1, 05));
                Persona persona10 = new Persona("FRVK040327HG7", "Karim", "Franco", "Valencia", "6441234537", new GregorianCalendar(2004, 03 - 1, 27));
                Persona persona11 = new Persona("GOOD010120HU7", "Daniela", "Gonzalez", "Ochoa", "6441099021", new GregorianCalendar(2001, 01 - 1, 20));
                Persona persona12 = new Persona("GURJ001231AG6", "Jesus Ernesto", "Gutierrez", "Robles", "6441906767", new GregorianCalendar(2000, 12 - 1, 31));
                Persona persona13 = new Persona("GAAG001221HD7", "Ana Gabriela", "Galaviz", "Acuña", "6442893627", new GregorianCalendar(2000, 12 - 1, 21));
                Persona persona14 = new Persona("VACJ901004KU7", "Jovani", "Vazquez", "Castro", "6448902309", new GregorianCalendar(1990, 10 - 1, 04));
                Persona persona15 = new Persona("GRBA930626JU7", "Ariana", "Grande", "Butera", "6441892093", new GregorianCalendar(1993, 06 - 1, 26));
                Persona persona16 = new Persona("TAGR490726JS3", "Roger", "Taylor", "Gonzales", "6441680865", new GregorianCalendar(1949, 07 - 1, 26));
                Persona persona17 = new Persona("BUGJ020818VG2", "Jacquelyn", "Bustamante", "De Espinoza", "644290737", new GregorianCalendar(2002, 8 - 1, 18));
                Persona persona18 = new Persona("GAPS020818NY5", "Sara", "Garcia", "Jusaino", "6441892084", new GregorianCalendar(2002, 8 - 1, 18));
                Persona persona19 = new Persona("ANIA021125TG3", "Andres Ulises", "Angulo", "Islas", "6441779757", new GregorianCalendar(2002, 11 - 1, 25));
                Persona persona20 = new Persona("BACK030117NH5", "Kennia", "Bracamontes", "Cota", "6441234167", new GregorianCalendar(2003, 01 - 1, 17));

                Persona[] personas = new Persona[]{persona1, persona2, persona3, persona4, persona5, persona6, persona7, persona8, persona9, persona10, persona11, persona12, persona13, persona14, persona15, persona16, persona17, persona18, persona19, persona20};

                em.getTransaction().begin();
                for (Persona persona : personas) {
                    // Encriptar el teléfono antes de insertarlo
                    String telefonoEncriptado = encriptarTelefono(persona.getTelefono());
                    persona.setTelefono(telefonoEncriptado);
                    em.persist(persona);
                }
                em.getTransaction().commit();

                personasInsertadas = true;
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
        }

        if (personasInsertadas) {
            JOptionPane.showMessageDialog(null, "Datos insertados correctamente en la base de datos.",
                    "Insersión de personas", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Busca una persona en la base de datos por su RFC.
     *
     * @param rfc El RFC de la persona que se desea buscar.
     * @return La persona encontrada.
     */
    @Override
    public Persona buscarPersonasRFC(String rfc) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        List<Predicate> parametros = new ArrayList<>();

        if (rfc != null) {
            parametros.add(cb.equal(root.get("rfc"), rfc));
        }

        cq.select(root).where(parametros.toArray(Predicate[]::new));
        TypedQuery<Persona> query = em.createQuery(cq);
        return query.getSingleResult();
    }

    /**
     * Busca personas en la base de datos por varios criterios como RFC, nombre y año de nacimiento.
     *
     * @param rfc El RFC de la persona.
     * @param nombre El nombre de la persona.
     * @param anio El año de nacimiento de la persona.
     * @return Una lista de personas que coinciden con los criterios de búsqueda.
     */
    @Override
    public List<Persona> buscarPersonas(String rfc, String nombre, int anio) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
        Root<Persona> root = cq.from(Persona.class);
        List<Predicate> predicates = new ArrayList<>();

        if (rfc != null && !rfc.isEmpty()) {
            predicates.add(cb.equal(root.get("rfc"), rfc));
        }

        if (nombre != null && !nombre.isEmpty()) {
            String[] nombres = nombre.split(" ");
            if (nombres.length >= 1) {
                predicates.add(cb.like(root.get("nombres"), "%" + nombres[0] + "%"));
            }
            if (nombres.length >= 2) {
                predicates.add(cb.like(root.get("apellido_paterno"), "%" + nombres[1] + "%"));
            }
            if (nombres.length >= 3) {
                predicates.add(cb.like(root.get("apellido_materno"), "%" + nombres[2] + "%"));
            }
        }

        if (anio > 0) {
            predicates.add(cb.equal(cb.function("YEAR", Integer.class, root.get("fechaNacimiento")), anio));
        }

        cq.select(root).where(predicates.toArray(new Predicate[0]));

        TypedQuery<Persona> query = em.createQuery(cq);
        return query.getResultList();
    }

}
