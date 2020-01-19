package exercise03_2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class AppBook {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;

    static {
        Configuration configuration = new Configuration();
        configuration.configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    }
    public static void main(String[] args) {
        // Hibernate placeholders
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();
            Book book = new Book("how to be me",1223,"hewan");
            Book book1 = new Book("ninja turtle",3454,"abebe teka");
            Publisher Publisher = new Publisher();
            Publisher.setName("motion publishing");
            Publisher Publisher1 = new Publisher();
            Publisher1.setName("integrative printing plc");
            book.setPublisher(Publisher);
            book1.setPublisher(Publisher);

            session.persist(book);
            session.persist(book1);
            session.persist(Publisher);
            session.persist(Publisher1);
            session.getTransaction().commit();

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

        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            // retieve all cars
            @SuppressWarnings("unchecked")
            List<Book> booklist = session.getNamedQuery("from Book").list();
            for (Book book : booklist) {
                System.out.println("title= " + book.getTitle()  + " Author" + book.getAuthor() + "publisher detail" + book.getPublisher() );

            }
           
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
    }



}
