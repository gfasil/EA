package exercise03_2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class AppDepartment {
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
            Department department = new Department("cs");
            Department department1 = new Department("FBE");

            Employee employee = new Employee("henok");

            Employee employee1 = new Employee("nati");

            department.addEmployee(employee);
            department1.addEmployee(employee1);

            session.persist(department);
            session.persist(department1);
            session.persist(employee);
            session.persist(employee1);
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
            System.out.println("begin trans");
            // retieve all cars
            @SuppressWarnings("unchecked")

            List<Department> departmentlist = session.createQuery("from Department").list();
        //    System.out.println("inside for loop begin trans");
            for (Department department : departmentlist) {

                System.out.println("name= " + department.getName()  );
          department.getEmployees().stream().map(x->x.getName()).forEach(x->System.out.println(x));
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
