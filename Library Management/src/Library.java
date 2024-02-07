import java.util.ArrayList;

public class Library {
    // fields
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();

    // constructor default
    public Library() {
    }

    // constructor parameter
    public Library(ArrayList<Book> books, ArrayList<Student> students) {
        this.books = books;
        this.students = students;
    }

    // getter and setter
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + books +
                ", students=" + students +
                '}';
    }

    // add methode

    // delete methode

    // search methode
}
