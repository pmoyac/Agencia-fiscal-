package daos;

import entidadesJPA.Persona;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

/**
 *
 * @author adria
 */
public class PersonasDAO implements IPersonasDAO{
    
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Persistencia");
    EntityManager em = emFactory.createEntityManager();

    @Override
    public void insertarPersonas() {
        try {
            Persona persona1 = new Persona("GURA030404EG3", "Adriana", "Gutierrez", "Robles", 6448989093L, new GregorianCalendar(2003,04,04));
            Persona persona2 = new Persona("MOCP880503JV4", "Pedro Antonio", "Moya", "Castro", 6442789903L, new GregorianCalendar(1988,05,03));
            Persona persona3 = new Persona("NUCK040104HI8", "Kamila Noemy", "Nuñez", "Choix", 6442890063L, new GregorianCalendar(2004,01,04));
            Persona persona4 = new Persona("PIVA040822JR2", "Alexa Maria", "Picos", "Valenzuela", 6442157463L, new GregorianCalendar(2004,8,22));
            Persona persona5 = new Persona("MOEE040223JE6", "Esmeralda", "Molina", "Estrada", 6448543213L, new GregorianCalendar(2004,02,23));
            Persona persona6 = new Persona("BETI030131FG2", "Itza Paulina", "Bernal", "Teran", 6442846734L, new GregorianCalendar(2003,01,31));
            Persona persona7 = new Persona("FURS030331JD3", "Suseth Alejandra", "Fuentes", "Ruiz", 6442985263L, new GregorianCalendar(2003,03,31));
            Persona persona8 = new Persona("GUTD030818AU6", "Darian", "Gutierrez", "Torres", 6442489762L, new GregorianCalendar(2003,8,18));
            Persona persona9 = new Persona("GIMS030605UY4", "Sandra Paola", "Giron", "Mendivil", 6441234897L, new GregorianCalendar(2003,06,05));
            Persona persona10 = new Persona("FRVK040327HG7", "Karim", "Franco", "Valencia", 6441234537L, new GregorianCalendar(2004,03,27));
            Persona persona11 = new Persona("GOOD010120HU7", "Daniela", "Gonzalez", "Ochoa", 6441099021L, new GregorianCalendar(2001,01,20));
            Persona persona12 = new Persona("GURJ001231AG6", "Jesus Ernesto", "Gutierrez", "Robles", 6441906767L, new GregorianCalendar(2000,12,31));
            Persona persona13 = new Persona("GAAG001221HD7", "Gabriela", "Galaviz", "Acuña", 6442893627L, new GregorianCalendar(2000,12,21));
            Persona persona14 = new Persona("VACJ901004KU7", "Jovani", "Vazquez", "Castro", 6448902309L, new GregorianCalendar(1990,10,04));
            Persona persona15 = new Persona("GRBA930626JU7", "Ariana", "Grande", "Butera", 6441892093L, new GregorianCalendar(1993,06,26));
            Persona persona16 = new Persona("TAGR490726JS3", "Roger", "Taylor", "Gonzales", 6441680865L, new GregorianCalendar(1949,07,26));
            Persona persona17 = new Persona("BUGJ020818VG2", "Jacquelin", "Bustamante", "Garcia", 644290737L, new GregorianCalendar(2002,8,18));
            Persona persona18 = new Persona("GAPS020818NY5", "Sara", "Garcia", "Perez", 6441892084L, new GregorianCalendar(2002,8,18));
            Persona persona19 = new Persona("ANIA021125TG3", "Andres Ulises", "Angulo", "Islas", 6441779757L, new GregorianCalendar(2002,11,25));
            Persona persona20 = new Persona("BRCK030117NH5", "Kennia", "Bracamontes", "Cota", 6441234167L, new GregorianCalendar(2003,01,17));
            
            Persona[] personas = new Persona[]{persona1, persona2, persona3, persona4, persona5, persona6, persona7, persona8, persona9, persona10, persona11, persona12, persona13, persona14, persona15, persona16, persona17, persona18, persona19, persona20};

            em.getTransaction().begin();
            for (Persona persona : personas) {
                em.persist(persona);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    @Override
    public Persona buscarPersonasRFC(String rfc) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
