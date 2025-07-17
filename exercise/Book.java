public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isCheckedOut = false;
    }

    public void checkOut() {
        if (!isCheckedOut) {
            isCheckedOut = true;
        }
    }

    public void returnBook() {
        if (isCheckedOut) {
            isCheckedOut = false;
        }
    }

    public boolean isAvailable() {
        return !isCheckedOut;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Available: " + book.isAvailable());
        book.checkOut();
        System.out.println("Available after checkout: " + book.isAvailable());
        book.returnBook();
        System.out.println("Available after return: " + book.isAvailable());
    }
}