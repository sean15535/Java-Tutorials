// Course.java
import java.util.*;

// Represents a course offered by the university
public class Course {
    private String courseCode;
    private String courseName;
    private int maxCapacity;
    private List<Student> enrolledStudents; // List of students enrolled in the course
    private static int totalEnrolledStudents = 0; // Static counter for total enrolled students across all courses

    public Course(String courseCode, String courseName, int maxCapacity) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.maxCapacity = maxCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseCode() { return courseCode; }
    public String getCourseName() { return courseName; }
    public int getMaxCapacity() { return maxCapacity; }
    public List<Student> getEnrolledStudents() { return enrolledStudents; }

    // Enroll a student if the course has not reached maximum capacity
    public boolean enrollStudent(Student student) {
        if (enrolledStudents.size() < maxCapacity) {
            enrolledStudents.add(student);
            totalEnrolledStudents++;
            return true;
        }
        return false;
    }

    // Return the total number of enrolled students across all courses
    public static int getTotalEnrolledStudents() {
        return totalEnrolledStudents;
    }
}

// Student.java
import java.util.*;

// Represents a student at the university
public class Student {
    private String name;
    private String id;
    private Map<Course, Double> courseGrades; // Mapping of course to assigned grade

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courseGrades = new HashMap<>();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    // Enroll the student in a course without assigning a grade yet
    public void enrollInCourse(Course course) {
        if (!courseGrades.containsKey(course)) {
            courseGrades.put(course, null);
        }
    }

    // Assign a grade for a specific course
    public void assignGrade(Course course, double grade) {
        if (courseGrades.containsKey(course)) {
            courseGrades.put(course, grade);
        }
    }

    public Map<Course, Double> getCourseGrades() {
        return courseGrades;
    }
}

// CourseManagement.java
import java.util.*;

// Provides static methods to manage courses and student enrollment
public class CourseManagement {
    private static List<Course> courses = new ArrayList<>(); // List of all available courses

    // Add a new course
    public static void addCourse(String code, String name, int capacity) {
        Course course = new Course(code, name, capacity);
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    // Enroll a student in a specific course
    public static void enrollStudent(Student student, Course course) {
        if (course.enrollStudent(student)) {
            student.enrollInCourse(course);
            System.out.println("Student enrolled in course.");
        } else {
            System.out.println("Enrollment failed. Course capacity reached.");
        }
    }

    // Assign a grade to a student for a specific course
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
        System.out.println("Grade assigned successfully.");
    }

    // Calculate the average grade of all courses the student is enrolled in
    public static double calculateOverallGrade(Student student) {
        Map<Course, Double> grades = student.getCourseGrades();
        double total = 0;
        int count = 0;
        for (Double grade : grades.values()) {
            if (grade != null) {
                total += grade;
                count++;
            }
        }
        return (count > 0) ? total / count : 0.0;
    }

    // Get the list of all courses
    public static List<Course> getCourses() {
        return courses;
    }
}

// Main.java (Administrator Interface)
import java.util.*;

// Command-line interface for administrators
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>(); // List to keep track of created students

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Course Management System ---");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student");
            System.out.println("3. Assign Grade");
            System.out.println("4. Calculate Overall Grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    addCourse();
                    break;
                case 2:
                    enrollStudent();
                    break;
                case 3:
                    assignGrade();
                    break;
                case 4:
                    calculateGrade();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Prompts for course details and adds a course
    private static void addCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        System.out.print("Enter course name: ");
        String name = scanner.nextLine();
        System.out.print("Enter max capacity: ");
        int cap = Integer.parseInt(scanner.nextLine());
        CourseManagement.addCourse(code, name, cap);
    }

    // Enroll a new student in a selected course
    private static void enrollStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = new Student(name, id);
        students.add(student);

        listCourses();
        System.out.print("Enter course index to enroll: ");
        int idx = Integer.parseInt(scanner.nextLine());
        if (idx >= 0 && idx < CourseManagement.getCourses().size()) {
            Course course = CourseManagement.getCourses().get(idx);
            CourseManagement.enrollStudent(student, course);
        } else {
            System.out.println("Invalid course index.");
        }
    }

    // Assign a grade to a student for a selected course
    private static void assignGrade() {
        Student student = findStudent();
        if (student == null) return;

        listCourses();
        System.out.print("Enter course index to assign grade: ");
        int idx = Integer.parseInt(scanner.nextLine());
        if (idx >= 0 && idx < CourseManagement.getCourses().size()) {
            Course course = CourseManagement.getCourses().get(idx);
            System.out.print("Enter grade: ");
            double grade = Double.parseDouble(scanner.nextLine());
            CourseManagement.assignGrade(student, course, grade);
        } else {
            System.out.println("Invalid course index.");
        }
    }

    // Calculate and display the average grade for a student
    private static void calculateGrade() {
        Student student = findStudent();
        if (student != null) {
            double grade = CourseManagement.calculateOverallGrade(student);
            System.out.println("Overall Grade: " + grade);
        }
    }

    // Find a student by ID
    private static Student findStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        System.out.println("Student not found.");
        return null;
    }

    // Display all available courses with their indexes
    private static void listCourses() {
        List<Course> courses = CourseManagement.getCourses();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println(i + ". " + courses.get(i).getCourseName() + " (" + courses.get(i).getCourseCode() + ")");
        }
    }
}
