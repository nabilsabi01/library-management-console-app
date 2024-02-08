import java.util.ArrayList;

public class Student {
    // fields
    private String name;
    private String address;
    private String id;
    private ArrayList<Book> books;

    public Student() {
    }

    // constructor paramether
    public Student(String name, String address, String id) {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
}
