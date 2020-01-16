package cs544.exercise02_2;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class AppPerson {
	private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static Session session = null;
	static Transaction tx = null;
	static DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.US);
	
    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    
    public static void main(String[] args) throws ParseException {
    	createAndPersist(); 
    	retrieveAll();
    	retriveAndDelete();
    }
    
    private static void  createAndPersist() throws ParseException {
    	try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			Person p1 = new Person("First", "firstLastName", df.parse("1987/12/10")); 
			session.persist(p1);
			
			Person p2 = new Person("Second", "secondLastName", df.parse("1988/12/10")); 
			session.persist(p2);
			
			Person p3 = new Person("Third", "thirdLastName", df.parse("1989/12/10")); 
			session.persist(p3);
			
			tx.commit();
			
    	}catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    
    private static void retrieveAll() {
    	try {
    		session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			List<Person> persons = session.createQuery("from Person").list(); 
			StringBuilder sb = new StringBuilder(); 
			for(Person p: persons) {
				sb.append("First Name: ")
				  .append(p.getFirstName())
				  .append(" , ")
				  .append(" Last Name: ")
				  .append(p.getLastName())
				  .append(" , ")
				  .append(" Date of Birth : ")
				  .append(p.getDateOfBirth())
				  .append("\n"); 	
			
			}
			
			System.out.println(sb.toString());
    	}catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
    }
    
    private static void retriveAndDelete() throws ParseException {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Person p = (Person) session.load(Person.class, 1L);
			p.setFirstName("updated");
			p.setLastName("person");
			p.setDateOfBirth(df.parse("1990/12/10"));

			Person d = (Person) session.load(Person.class, 2L);
			session.delete(d);
			tx.commit();

		} catch (HibernateException e) {
			if (tx != null) {
				System.err.println("Rolling back: " + e.getMessage());
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		retrieveAll();
	}
}
