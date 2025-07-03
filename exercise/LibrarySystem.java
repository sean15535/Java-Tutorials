import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Book {
    String title;
    String author;
    int quantity;

    Book(String title, String author, int quantity) {
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    void addCopies(int amount) {
        this.quantity += amount;
    }

    boolean borrowCopies(int amount) {
        if (amount <= quantity) {
            this.quantity -= amount;
            return true;
        } else {
            return false;
        }
    }

    void returnCopies(int amount) {
        this.quantity += amount;
    }
}

public class LibrarySystem {
    private static final Map<String, Book> library = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n===== Library System =====");
            System.out.println("1. Add Books");
            System.out.println("2. Borrow Books");
            System.out.println("3. Return Books");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    borrowBook();
                    break;
                case "3":
                    returnBook();
                    break;
                case "4":
                    running = false;
                    System.out.println("Exiting Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid input. Please enter a number from 1 to 4.");
            }
        }

        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();

        System.out.print("Enter book author: ");
        String author = scanner.nextLine().trim();

        System.out.print("Enter quantity: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Quantity must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Please enter a number.");
            return;
        }

        if (library.containsKey(title)) {
            library.get(title).addCopies(quantity);
            System.out.println("Book exists. Updated quantity.");
        } else {
            library.put(title, new Book(title, author, quantity));
            System.out.println("New book added to the library.");
        }
    }

    private static void borrowBook() {
        System.out.print("Enter book title to borrow: ");
        String title = scanner.nextLine().trim();

        if (!library.containsKey(title)) {
            System.out.println("Book not found in the library.");
            return;
        }

        System.out.print("Enter number of copies to borrow: ");
        int amount;
        try {
            amount = Integer.parseInt(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
            return;
        }

        Book book = library.get(title);
        if (book.borrowCopies(amount)) {
            System.out.println("Borrowed " + amount + " copy(ies) of '" + title + "'.");
        } else {
            System.out.println("Not enough copies available. Only " + book.quantity + " left.");
        }
    }

    private static void returnBook() {
        System.out.print("Enter book title to return: ");
        String title = scanner.nextLine().trim();

        if (!library.containsKey(title)) {
            System.out.println("This book does not belong to our library system.");
            return;
        }

        System.out.print("Enter number of copies to return: ");
        int amount;
        try {
            amount = Integer.parseInt(scanner.nextLine());
            if (amount <= 0) {
                System.out.println("Amount must be a positive number.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a number.");
            return;
        }

        Book book = library.get(title);
        book.returnCopies(amount);
        System.out.println("Returned " + amount + " copy(ies) of '" + title + "'.");
    }
}
