//package hybernate.service.serviceImpl;
//
//import org.example.dao.StudentDao;
//import org.example.dao.daoImpl.StudentDaoImpl;
//import org.example.entity.Student;
//import org.example.service.StudentService;
//
//import java.util.List;
//
//public class StudentServiceImpl implements StudentService {
//    StudentDao studentDao = new StudentDaoImpl();
//    @Override
//    public String saveStudent(Student student) {
//        return studentDao.saveStudent(student);
//    }
//
//    @Override
//    public Student getStudentById(Long studentId) {
//        return studentDao.getStudentById(studentId);
//    }
//
//    @Override
//    public List<Student> getAllStudents() {
//        return studentDao.getAllStudents();
//    }
//
//    @Override
//    public Student updateStudent(Long studentId, Student newStudent) {
//        return studentDao.updateStudent(studentId,newStudent);
//    }
//
//    @Override
//    public String deleteStudentById(Long studentId) {
//        return studentDao.deleteStudentById(studentId);
//    }
//}
