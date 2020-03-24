package test;

import entities.RedSocial;
import entities.RedUsuario;
import entities.Usuario;
import enums.Sexo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author brend
 */
public class test {

    public static void main(String[] args) {
        EntityManagerFactory managerFactory
                = Persistence.createEntityManagerFactory("RedesSocialesPU");
        EntityManager entityManager
                = managerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        ArrayList<Object> entidades = new ArrayList<>();

        RedSocial r1 = new RedSocial("facebook", "www.facebook.com", 
                new GregorianCalendar(2007, Calendar.FEBRUARY, 5));
        RedSocial r2 = new RedSocial("Twitter", "www.twitter.com", 
                new GregorianCalendar(2006, Calendar.MARCH, 21));
        RedSocial r3 = new RedSocial("Instagram", "www.instagram.com", 
                new GregorianCalendar(2010, Calendar.OCTOBER, 6));
        entidades.add(r1);
        entidades.add(r2);
        entidades.add(r3);

        Usuario u1 = new Usuario("Sabrina Spellman", "BrinaSpellman@gmail.com",
                new GregorianCalendar(2000, Calendar.OCTOBER, 31), Sexo.FEMENINO);
        Usuario u2 = new Usuario("Lilith Morningstar", "madamSatan@gmail.com",
                new GregorianCalendar(1977, Calendar.JUNE, 3), Sexo.FEMENINO);
        
        u1.addRedSocial(new RedUsuario(r3, u1, new GregorianCalendar
            (2015, Calendar.MARCH, 17), "BrinaMorningstar"));
        u1.addRedSocial(new RedUsuario(r2, u1, new GregorianCalendar
            (2012, Calendar.FEBRUARY, 29), "QueenOfHell"));
        
        u2.addRedSocial(new RedUsuario(r3, u2, new GregorianCalendar
            (2016, Calendar.NOVEMBER, 22), "MadamSatan"));
        u2.addRedSocial(new RedUsuario(r1, u2, new GregorianCalendar
            (2014, Calendar.AUGUST, 8), "Lilith Morningstar"));
        
        entidades.add(u1);
        entidades.add(u2);
        
        for (Object entidad : entidades) {
            entityManager.persist(entidad);
        }
        
        entityManager.getTransaction().commit();
    }
}
