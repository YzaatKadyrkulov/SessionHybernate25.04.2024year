package hybernate.config;

import hybernate.entity.Course;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.Properties;

public class HibernateConfig {
    public static EntityManagerFactory getEntityManagerFactory(){
            try{
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "org.postgresql.Driver");
                properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/topics");
                properties.put(Environment.USER, "postgres");
                properties.put(Environment.PASS, "1234");
                properties.put(Environment.HBM2DDL_AUTO, "create"); // I need to change on update after I will create table
                properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                properties.put(Environment.SHOW_SQL, "true");

                Configuration configuration = new Configuration();
                configuration.addProperties(properties);
                configuration.addAnnotatedClass(Course.class);

                return configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
            }catch (HibernateException e){
                System.out.println(e.getMessage());
            }
            return null;
        }
//        Properties properties = new Properties();
//        properties.put(Environment.DRIVER, "org.postgresql.Driver");
//        properties.put(Environment.URL, "jdbc:postgresql://localhost:5432/topics");
//        properties.put(Environment.USER, "postgres");
//        properties.put(Environment.PASS, "1234");
//        properties.put(Environment.HBM2DDL_AUTO, "update"); // I need to change on update after I will create table
//        properties.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
//        properties.put(Environment.SHOW_SQL, "true");
//
//        Configuration configuration = new Configuration();
//        configuration.addProperties(properties);
//        configuration.addAnnotatedClass(Course.class);
//
////        SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//        return configuration.buildSessionFactory();
    }

