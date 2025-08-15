import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return String.format("%s (%d) - %s : $%.2f", name, age, department, salary);
    }
}

public class EmployeeDataProcessor {
    public static void main(String[] args) {
        // 1. Read and store dataset in a collection
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 28, "IT", 75000),
            new Employee("Bob", 35, "HR", 60000),
            new Employee("Charlie", 32, "Finance", 82000),
            new Employee("David", 45, "IT", 95000),
            new Employee("Eva", 29, "Marketing", 68000)
        );

        // Age threshold for filtering
        int ageThreshold = 30;

        // 2. Function interface: concatenate name and department
        Function<Employee, String> nameDeptFunction =
                emp -> emp.getName() + " - " + emp.getDepartment();

        // 3. Using streams to generate new collection of concatenated strings
        List<String> nameDeptList = employees.stream()
                .map(nameDeptFunction) // apply function
                .collect(Collectors.toList());

        // 4. Calculate average salary using streams
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        // 5. Filter employees above a certain age and collect
        List<Employee> filteredEmployees = employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .collect(Collectors.toList());

        // 6. Output results
        System.out.println("=== Employee Name & Department List ===");
        nameDeptList.forEach(System.out::println);

        System.out.println("\nAverage Salary of All Employees: $" + String.format("%.2f", averageSalary));

        System.out.println("\n=== Employees Older Than " + ageThreshold + " ===");
        filteredEmployees.forEach(System.out::println);

        // BONUS: Highest paid employee in each department
        System.out.println("\n=== Highest Paid Employee Per Department ===");
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        highestPaidByDept.forEach((dept, empOpt) ->
                System.out.println(dept + ": " + empOpt.orElse(null)));
    }
}

/*
----------------------------------- EXPLANATION -----------------------------------
The Function Interface in Java (java.util.function.Function<T, R>) represents a function that
takes one argument of type T and returns a result of type R.

Purpose:
- To provide a standard way to define transformations on objects.
- Often used with streams to map or transform data.

Characteristics:
- Has a single abstract method: R apply(T t).
- Can be implemented using lambda expressions or method references.
- Useful for functional-style programming in Java.

Usage in this Program:
- nameDeptFunction is defined as Function<Employee, String>.
- It takes an Employee object and returns a string in the format "Name - Department".
- Applied in the stream using .map(nameDeptFunction) to transform the dataset.
-----------------------------------------------------------------------------------
*/
