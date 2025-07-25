import java.util.ArrayList;
import java.util.List;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>(); // All courses

    // Add a new course to the system
    public static void addCourse(String code, String name, int capacity) {
        Course course = new Course(code, name, capacity);
        courses.add(course);
    }

    // Get all courses
    public static List<Course> getCourses() {
        return courses;
    }

    // Enroll a student in a course
    public static boolean enrollStudent(Student student, Course course) {
        return student.enrollInCourse(course);
    }

    // Assign a grade to a student for a course
    public static boolean assignGrade(Student student, Course course, double grade) {
        return student.assignGrade(course, grade);
    }

    // Calculate overall grade average for a student
    public static double calculateOverallGrade(Student student) {
        return student.calculateOverallGrade();
    }
}
