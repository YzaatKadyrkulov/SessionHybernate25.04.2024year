package hybernate;


import hybernate.entity.Course;
import hybernate.service.CourseService;
import hybernate.service.serviceImpl.CourseServiceImpl;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();
        System.out.println(courseService.saveCourse(new Course("Java", 13)));

        System.out.println(courseService.getCourseById(1L));
        System.out.println(courseService.updateCourse(1L, new Course("JS",13)));

        System.out.println(courseService.getAllCourses());

        System.out.println(courseService.deleteCourseById(1L));

    }
}
