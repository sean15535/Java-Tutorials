public class AgeValidator {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or older.");
        }
        System.out.println("Access granted.");
    }

    public static void main(String[] args) {
        checkAge(15); // Will throw an exception
    }
}
