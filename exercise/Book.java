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
}