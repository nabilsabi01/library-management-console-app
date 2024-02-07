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


    // add methode
    public void addBook(Book book){
        books.add(book);
    }

    // delete methode
    public void delBook(Book book){
        books.remove(book);
    }

    // search methode by title
    public Book searchBook(String title){
        for (Book book : books){
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // display books
    public void displayBook(ArrayList<Book> books){

    }
}
