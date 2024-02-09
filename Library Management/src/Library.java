import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Library {
    // fields
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // constructor default
    public Library() {
    }

    // getter and setter methods
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

    // methods for managing books and students
    public void addBook(Book book) {
        books.add(book);
    }

    public void delBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // display books
    public void displayAllBooks() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Book book : books) {
            System.out.println(
                    "Title: " + book.getTitle() +
                    "\nAuthor: " + book.getAuthor() +
                    "\nISBN: " + book.getIsbn() +
                    "\nDate Publication: " + formatter.format(book.getPublishDate())
            );
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void delStudent(Student student) {
        students.remove(student);
    }

    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // methode for display list of students
    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(
                    "Nom: " + student.getName() +
                    "\nAddresse: " + student.getAddress() +
                    "\nID: " + student.getId()
            );
        }
    }
}
