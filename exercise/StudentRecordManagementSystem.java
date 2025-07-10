import java.util.Scanner;

public class StudentRecordManagementSystem {

    // Student data storage (individual variables)
    static final int MAX_STUDENTS = 100;
    static String[] names = new String[MAX_STUDENTS];
    static int[] ids = new int[MAX_STUDENTS];
    static int[] ages = new int[MAX_STUDENTS];
    static String[] grades = new String[MAX_STUDENTS];

    // Static variable to track total number of students
    static int studentCount = 0;

    // Scanner object for user input
    static Scanner scanner = new Scanner(System.in);

    // Method to add a new student
    public static void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student list is full. Cannot add more students.");
            return;
        }

        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            // Check if ID already exists
            if (findStudentIndexById(id) != -1) {
                System.out.println("Student ID already exists.");
                return;
            }

            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Student Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Student Grade: ");
            String grade = scanner.nextLine();

            ids[studentCount] = id;
            names[studentCount] = name;
            ages[studentCount] = age;
            grades[studentCount] = grade;

            studentCount++;

            System.out.println("Student added successfully.\n");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values for ID and Age.\n");
        }
    }

    // Method to update student information
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            int index = findStudentIndexById(id);

            if (index == -1) {
                System.out.println("Student with ID " + id + " not found.\n");
                return;
            }

            System.out.print("Enter New Name: ");
            names[index] = scanner.nextLine();

            System.out.print("Enter New Age: ");
            ages[index] = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter New Grade: ");
            grades[index] = scanner.nextLine();

            System.out.println("Student information updated successfully.\n");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter numeric values for ID and Age.\n");
        }
    }

    // Method to view student details
    public static void viewStudent() {
        System.out.print("Enter Student ID to view: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            int index = findStudentIndexById(id);

            if (index == -1) {
                System.out.println("Student with ID " + id + " not found.\n");
                return;
            }

            System.out.println("Student Details:");
            System.out.println("ID    : " + ids[index]);
            System.out.println("Name  : " + names[index]);
            System.out.println("Age   : " + ages[index]);
            System.out.println("Grade : " + grades[index]);
            System.out.println();

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a numeric ID.\n");
        }
    }

    // Helper method to find student index by ID
    public static int findStudentIndexById(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (ids[i] == id) {
                return i;
            }
        }
        return -1;
    }

    // Method to display the admin interface
    public static void displayMenu() {
        while (true) {
            System.out.println("========== Student Record Management ==========");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    updateStudent();
                    break;
                case "3":
                    viewStudent();
                    break;
                case "4":
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select from 1 to 4.\n");
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        displayMenu();
    }
}
