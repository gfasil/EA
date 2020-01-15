package com.ea.exercise01;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class AppBook {

	public static SessionFactory sessionFactory;

	static {
		// it reads the hibernate config file and makes hibernate read for use
		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// creates a session factory needed to get sessions to perform different tasks
		sessionFactory = config.buildSessionFactory(sr);
	}

	@SuppressWarnings({ "deprecation", "deprecation", "deprecation" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = null;
		Transaction txn = null;

		Book b1 = new Book();
		b1.setAuthor("fasil");
		b1.setISBN("1234");
		b1.setPrice(100);
		b1.setTitle("The last Supper");
		b1.setPublish_date(new java.util.Date(12, 10, 2019));

		Book b2 = new Book();
		b2.setAuthor("Hewan");
		b2.setISBN("23543");
		b2.setPrice(106);
		b2.setTitle("How is servived");
		b2.setPublish_date(new java.util.Date(2000, 10, 10));

		Book b3 = new Book();
		b3.setAuthor("tomas");
		b3.setISBN("5436");
		b3.setPrice(200);
		b3.setTitle("Happiness equations");
		b3.setPublish_date(new java.util.Date(2010, 10, 10));
		
		// create array of book to loop through a perform different operations
		Book books[] = { b1, b2, b3 };

		try {
			// opens a new session
			session = sessionFactory.openSession();
			// creates a new transaction where you can perform different tasks inside it.
			txn = session.beginTransaction();

			// save the objects
			for (Book b : books) {
				session.persist(b);
				System.out.println(b);
			}

			// end the transaction after saving objects to database
			session.getTransaction().commit();

		} catch (HibernateException e) {

			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				session.close();

			}
		}

		try {
			session=sessionFactory.openSession();
			txn=session.beginTransaction();
			// get the list of books from database
			List<Book> booklist= session.createQuery("From book").list();
			// use for loop to display all books
			for(Book b:booklist) {
				System.out.println(b);
			}
			
			session.getTransaction().commit();
			

		} catch (HibernateException e) {

			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				session.close();

			}
		}
		
		try {
			session=sessionFactory.openSession();
			txn=session.beginTransaction();
			// get the a book from database
			Book book= (Book) session.get(Book.class, 2);
			//update book object
			book.setTitle("12 rules of life");
			book.setPrice(300);
			//	session.update(book);
			// get the a book to be deleted from database
			Book book1= (Book) session.get(Book.class, 3);
			//delete book from the database
			session.delete(book1);
			session.getTransaction().commit();
			

		} catch (HibernateException e) {

			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				session.close();

			}
		}
		
		try {
			session=sessionFactory.openSession();
			txn=session.beginTransaction();
			// get the list of books from database
			List<Book> booklist= session.createQuery("From book").list();
			// use for loop to display all books
			for(Book b:booklist) {
				System.out.println(b);
			}
			
			session.getTransaction().commit();
			

		} catch (HibernateException e) {

			session.getTransaction().rollback();

		} finally {
			if (session != null) {
				session.close();

			}
		}

	}

}
