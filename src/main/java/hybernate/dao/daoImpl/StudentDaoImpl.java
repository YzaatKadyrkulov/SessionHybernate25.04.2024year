//package hybernate.dao.daoImpl;
//
//import org.example.config.HibernateConfig;
//import org.example.dao.StudentDao;
//import org.example.entity.Student;
//import org.hibernate.Session;
//
//import java.util.List;
//
//public class StudentDaoImpl implements StudentDao {
//    @Override
//    public String saveStudent(Student student) {
//        try {
//            //We opened session
//            Session session = HibernateConfig.getSession().openSession();
//            // We started transaction
//            session.beginTransaction();
//            // hibernate instead of insert into, there is ready method persist;
//            session.persist(student);
//            session.getTransaction().commit();
//            session.close();
//            return "Success";
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public Student getStudentById(Long studentId) {
//        try {
//            Session session = HibernateConfig.getSession().openSession();
//            session.beginTransaction();
//            Student student = session.get(Student.class, studentId);
//            session.getTransaction().commit();
//            session.close();
//
//            return student;
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        try {
//            Session session = HibernateConfig.getSession().openSession();
//            session.beginTransaction();
//            List<Student> allStudents =
//                    session.createQuery("select s from Student s", Student.class).getResultList();
//            session.getTransaction().commit();
//            session.close();
//
//            return allStudents;
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    @Override
//    public Student updateStudent(Long studentId, Student newStudent) {
//        try {
//            Session session = HibernateConfig.getSession().openSession();
//            session.beginTransaction();
//
//            Student oldStudent = session.get(Student.class, studentId);
//            oldStudent.setFirstName(newStudent.getFirstName());
//            oldStudent.setLastName(newStudent.getLastName());
//            oldStudent.setEmail(newStudent.getEmail());
//            oldStudent.setAge(newStudent.getAge());
//            oldStudent.setGender(newStudent.getGender());
//
//            session.getTransaction().commit();
//            session.close();
//
//            return oldStudent;
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//
//    //    @Override
////    public String deleteStudentById(Long studentId) {
////        Session session = HibernateConfig.getSession().openSession();
////        session.beginTransaction();
////
////        Student student = session.get(Student.class, studentId);
////        session.remove(student);
////        session.getTransaction().commit();
////        session.close();
////
////        return "Successfully removed";
////    }
//    @Override
//    public String deleteStudentById(Long studentId) {
//        try {
//            Session session = HibernateConfig.getSession().openSession();
//            session.beginTransaction();
//
//            Student student = session.get(Student.class, studentId);
//            if (student != null) {
//                session.remove(student);
//                session.getTransaction().commit();
//                session.close();
//                return "Successfully removed";
//            } else return "Not found";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//}
