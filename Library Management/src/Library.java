import java.util.ArrayList;

public class Library {
    // fields
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    // constructor default
    public Library() {
    }

    // constructor parameter
//    public Library(ArrayList<Book> books, ArrayList<Student> students) {
//        this.books = books;
//        this.students = students;
//    }
//
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

    // methods for managers books
    public void addBook(Book book){
        books.add(book);
    }

    public void delBook(Book book){
        books.remove(book);
    }

    public Book searchBook(String title){
        for (Book book : books){
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    // methods for managers students
    public void addStudent(Student student){
        students.add(student);
    }

    public void delStudent(String id){
        students.remove(id);
    }

    public Student searchStudent(String id){
        for (Student student : students){
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public void updateStudent(String id, String name, String address, ArrayList<Book> book){
        if (searchStudent(id)!= null){
            Student std = searchStudent(id);
            std.setName(name);
            std.setAddress(address);
            std.setBooks(book);
        }
    }

    // display books
    public void displayAllBooks(){
        for (Book book : books){
            System.out.println("Title: " + book.getTitle() + "\nAuthor: " + book.getAuthor() + "\nISBN: " + book.getIsbn() + "\nDate Publication: " + book.getPublishDate().toString());
        }
    }

    // display studens
    public void displayAllStudents(){
        for (Student student : students){
            System.out.println("Nom: " + student.getName() + "\nAddresse: " + student.getAddress() + "\nID: " + student.getId());
        }
    }
}
