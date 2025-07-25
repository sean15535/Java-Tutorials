import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        while (true) {
            // Display admin menu
            System.out.println("\n--- Course Enrollment & Grade Management ---");
            System.out.println("1. Add New Course");
            System.out.println("2. Add New Student");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Assign Grade");
            System.out.println("5. Calculate Overall Grade");
            System.out.println("6. View Total Enrolled Students");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add new course
                    System.out.print("Enter course code: ");
                    String code = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter max capacity: ");
                    int capacity = scanner.nextInt();
                    CourseManagement.addCourse(code, name, capacity);
                    System.out.println("Course added successfully.");
                    break;

                case 2:
                    // Add new student
                    System.out.print("Enter student name: ");
                    String sName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String sID = scanner.nextLine();
                    students.add(new Student(sName, sID));
                    System.out.println("Student added successfully.");
                    break;

                case 3:
                    // Enroll student
                    Student student = findStudent(scanner, students);
                    Course course = findCourse(scanner, CourseManagement.getCourses());
                    if (student != null && course != null) {
                        if (CourseManagement.enrollStudent(student, course)) {
                            System.out.println("Enrollment successful.");
                        } else {
                            System.out.println("Course is full.");
                        }
                    }
                    break;

                case 4:
                    // Assign grade
                    student = findStudent(scanner, students);
                    course = findCourse(scanner, CourseManagement.getCourses());
                    if (student != null && course != null) {
                        System.out.print("Enter grade: ");
                        double grade = scanner.nextDouble();
                        if (CourseManagement.assignGrade(student, course, grade)) {
                            System.out.println("Grade assigned.");
                        } else {
                            System.out.println("Student not enrolled in this course.");
                        }
                    }
                    break;

                case 5:
                    // Calculate overall grade
                    student = findStudent(scanner, students);
                    if (student != null) {
                        double avg = CourseManagement.calculateOverallGrade(student);
                        System.out.println("Overall Grade for " + student.getName() + ": " + avg);
                    }
                    break;

                case 6:
                    // View total enrollment
                    System.out.println("Total Enrolled Students: " + Course.getTotalEnrolledStudents());
                    break;

                case 7:
                    // Exit
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    // Helper method to find a student by ID
    private static Student findStudent(Scanner scanner, List<Student> students) {
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

    // Helper method to find a course by code
    private static Course findCourse(Scanner scanner, List<Course> courses) {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();
        for (Course c : courses) {
            if (c.getCourseCode().equals(code)) {
                return c;
            }
        }
        System.out.println("Course not found.");
        return null;
    }
}
