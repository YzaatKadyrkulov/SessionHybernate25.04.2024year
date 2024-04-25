package hybernate.dao;

import hybernate.entity.Course;

import java.util.List;

public interface CourseDao {
    String saveCourse(Course newCourse);

    Course getCourseById(Long courseId);

    String updateCourse(Long oldCourseId, Course newCourse);

    List<Course> getAllCourses();

    String deleteCourseById(Long courseId);
}
