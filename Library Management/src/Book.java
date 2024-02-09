import java.time.LocalDate;
import java.util.Date;

public class Book {
    // Fields
    private String title;
    private String author;
    private String isbn;
    private LocalDate publishDate;
    private Student student;

    // Constructors
    public Book() {
    }

    public Book(String title, String author, String isbn, LocalDate  publishDate) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.student = null;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate  getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate  publishDate) {
        this.publishDate = publishDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    // Methods
    public void updateBook(Book updatedBook) {
        if (updatedBook != null) {
            this.title = updatedBook.getTitle();
            this.author = updatedBook.getAuthor();
            this.isbn = updatedBook.getIsbn();
            this.publishDate = updatedBook.getPublishDate();
        } else {
            System.out.println("Les informations mises à jour sur le livre sont vide.");
        }
    }
}
