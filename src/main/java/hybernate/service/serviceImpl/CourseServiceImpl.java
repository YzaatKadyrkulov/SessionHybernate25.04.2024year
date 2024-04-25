package hybernate.service.serviceImpl;

import hybernate.dao.CourseDao;
import hybernate.dao.daoImpl.CourseDaoImpl;
import hybernate.entity.Course;
import hybernate.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    @Override
    public String saveCourse(Course newCourse) {
        return courseDao.saveCourse(newCourse);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public String updateCourse(Long oldCourseId, Course newCourse) {
        return courseDao.updateCourse(oldCourseId,newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }

    @Override
    public String deleteCourseById(Long courseId) {
        return courseDao.deleteCourseById(courseId);
    }
}
