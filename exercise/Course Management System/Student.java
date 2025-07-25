import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<Course, Double> enrolledCourses; // Map to hold enrolled courses and grades

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>();
    }

    // Getter for student name
    public String getName() {
        return name;
    }

    // Setter for student name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for student ID
    public String getId() {
        return id;
    }

    // Setter for student ID
    public void setId(String id) {
        this.id = id;
    }

    // Method to enroll in a course
    public boolean enrollInCourse(Course course) {
        if (course.enrollStudent()) { // Try enrolling in course (check capacity)
            enrolledCourses.put(course, null); // Grade will be assigned later
            return true;
        }
        return false; // Enrollment failed (full capacity)
    }

    // Method to assign grade for a course
    public boolean assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
            return true;
        }
        return false; // Course not found in enrollment
    }

    // Method to calculate overall grade average
    public double calculateOverallGrade() {
        double total = 0.0;
        int count = 0;
        for (Double grade : enrolledCourses.values()) {
            if (grade != null) {
                total += grade;
                count++;
            }
        }
        return count > 0 ? total / count : 0.0;
    }

    // Get all enrolled courses and grades
    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }
}
