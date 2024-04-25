package hybernate.dao.daoImpl;

import hybernate.config.HibernateConfig;
import hybernate.dao.CourseDao;
import hybernate.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManagerFactory();

    @Override
    public String saveCourse(Course newCourse) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(newCourse);
            entityManager.getTransaction().commit();
            return "Success";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }

    @Override
    public Course getCourseById(Long courseId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            //with java code:
            entityManager.find(Course.class, courseId);
            //with query:                                      //courseId вопросительный знактын ичине
            Query query = entityManager.createQuery("select c from Course c where c.id = : courseId").//age qual
                    setParameter("courseId", courseId);
            query.getSingleResult();

            Course getCourse = (Course) query.getSingleResult();
            entityManager.getTransaction().commit();
            return getCourse;
        } catch (HibernateException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public String updateCourse(Long oldCourseId, Course newCourse) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("update Course c set c.courseName =:courseName, c.price=:price where c.id = :courseId")
                    .setParameter("courseName", newCourse.getCourseName())
                    .setParameter("price", newCourse.getPrice())
                    .setParameter("courseId", oldCourseId).
                    executeUpdate();
            entityManager.getTransaction().commit();
            return "Success";
        } catch (HibernateException e) {
            return (e.getMessage());
        }
    }

    @Override
    public List<Course> getAllCourses() {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            List<Course> courses = entityManager.createQuery("select c from Course c", Course.class)
                    .getResultList();
            entityManager.getTransaction().commit();
            return courses;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String deleteCourseById(Long courseId) {
        try (EntityManager entityManager = entityManagerFactory.createEntityManager()) {
            entityManager.getTransaction().begin();
            int deleteCount = entityManager.createQuery("delete from Course c where c.id = :courseId").
                    setParameter("courseId", courseId)
                            .executeUpdate();
            entityManager.getTransaction().commit();
            return (deleteCount > 0) ? "Success" : "No course found with the provided ID";
        } catch (HibernateException e) {
            return e.getMessage();
        }
    }
}
