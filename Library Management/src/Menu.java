import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Menu {
    private Library library = new Library();
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Menu() {
    }

    // menu the students manage
    public void menuManageStudents() {
        while (true) {
            System.out.println("*************************************************************************");
            System.out.println("*******             Enaa-Lib : Gestion Des Apprenants           *********");
            System.out.println("*************************************************************************");
            System.out.println("********                    1: Ajouter Apprenant                 ********");
            System.out.println("********                    2: Supprimer Apprenant               ********");
            System.out.println("********                    3: Modifier Apprenant                ********");
            System.out.println("********                    4: Consultation Les Apprenants       ********");
            System.out.println("********                    5: Routeur Menu Principal            ********");
            System.out.println("*************************************************************************");
            System.out.println("*************************************************************************");
            System.out.println("Enter votre choix: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    library.displayAllStudents();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // menu the books manage
    public void menuManageBooks() {
        while (true) {
            System.out.println("***********************************************************************");
            System.out.println("********            Enaa-Lib : Gestion Des Livres              ********");
            System.out.println("***********************************************************************");
            System.out.println("********                     1: Ajouter Livre                  ********");
            System.out.println("********                     2: Supprimer Livre                ********");
            System.out.println("********                     3: Rechercher Livre               ********");
            System.out.println("********                     4: Modifier Livre                 ********");
            System.out.println("********                     5: Consultation des livres        ********");
            System.out.println("********                     6: Routeur Menu Principal         ********");
            System.out.println("***********************************************************************");
            System.out.println("***********************************************************************");
            System.out.println("Enter votre choix: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    deleteBook();
                    break;
                case 3:
                    searchBook();
                    break;
                case 4:
                    updateBook();
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    // home menu
    public void menuMain() {
        while (true) {
            System.out.println("******************************************************************************");
            System.out.println("********         Enaa-Lib : Gestion De Bibliothèque                   ********");
            System.out.println("******************************************************************************");
            System.out.println("********                    1: Gère Les Livres                        ********");
            System.out.println("********                    2: Gère Les Apprenants                    ********");
            System.out.println("********                    3: Emprunté Un Livre                      ********");
            System.out.println("********                    4: Retour Un Livre                        ********");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("Enter votre choix: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    menuManageBooks();
                    break;
                case 2:
                    menuManageStudents();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                default:
                    System.out.println("Choix invalide.");
            }
        }
    }

    private void addStudent() {
        scanner.nextLine();
        System.out.println("Nom:");
        String name = scanner.nextLine();
        System.out.println("Adresse:");
        String address = scanner.nextLine();
        System.out.println("ID:");
        String id = scanner.nextLine();
        library.addStudent(new Student(name, address, id));
        System.out.println("Apprenant ajouté avec succès.");
    }

    private void deleteStudent() {
        System.out.println("Entrez l'ID de l'apprenant à supprimer: ");
        String id = scanner.next();
        Student studentToDelete = library.searchStudent(id);
        if (studentToDelete != null) {
            library.delStudent(studentToDelete);
            System.out.println("Apprenant supprimé avec succès.");
        } else {
            System.out.println("Apprenant non trouvé.");
        }
    }

    private void updateStudent() {
        System.out.println("Entrez l'ID de l'apprenant à mettre à jour: ");
        String id = scanner.next();
        Student studentToUpdate = library.searchStudent(id);
        if (studentToUpdate != null) {
            scanner.nextLine();
            System.out.println("Nouveau nom:");
            String newName = scanner.nextLine();
            System.out.println("Nouvelle adresse:");
            String newAddress = scanner.nextLine();
            studentToUpdate.setName(newName);
            studentToUpdate.setAddress(newAddress);
            System.out.println("Mise à jour de l'apprenant réussie.");
        } else {
            System.out.println("Apprenant non trouvé.");
        }
    }

    // Method to add book
    public void addBook() {
        scanner.nextLine();
        System.out.println("Title:");
        String title = scanner.nextLine();
        System.out.println("Author:");
        String author = scanner.nextLine();
        System.out.println("ISBN:");
        String isbn = scanner.nextLine();
        System.out.println("Date Publication (dd/MM/yyyy):");
        String dateString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            LocalDate publishDate = LocalDate.parse(dateString, formatter);
            library.addBook(new Book(title, author, isbn, publishDate));
            System.out.println("Livre ajouté avec succès.");
        } catch (DateTimeParseException e) {
            System.out.println("format de date invalide.");
        }
    }

    private void deleteBook() {
        System.out.println("Titre du livre à supprimer: ");
        String title = scanner.next();
        Book bookToDelete = library.searchBook(title);
        if (bookToDelete != null) {
            library.delBook(bookToDelete);
            System.out.println("Livre supprimé avec succès.");
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    private void searchBook() {
        System.out.println("Titre du livre à rechercher: ");
        String title = scanner.next();
        Book foundBook = library.searchBook(title);
        if (foundBook != null) {
            System.out.println("Livre trouvé:");
            System.out.println("Titre: " + foundBook.getTitle());
            System.out.println("Auteur: " + foundBook.getAuthor());
            System.out.println("ISBN: " + foundBook.getIsbn());
            System.out.println("Date de publication: " + dateFormat.format(foundBook.getPublishDate()));
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    public void updateBook() {
        System.out.println("Titre du livre à modifier: ");
        String title = scanner.next();
        Book bookToUpdate = library.searchBook(title);
        if (bookToUpdate != null) {
            scanner.nextLine();
            System.out.println("Nouveau titre:");
            String newTitle = scanner.nextLine();
            System.out.println("Nouvel auteur:");
            String newAuthor = scanner.nextLine();
            System.out.println("Nouvel ISBN:");
            String newIsbn = scanner.nextLine();
            System.out.println("Nouvelle date de publication (dd/MM/yyyy):");
            String dateString = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            try {
                LocalDate newPublishDate = LocalDate.parse(dateString, formatter);
                bookToUpdate.setTitle(newTitle);
                bookToUpdate.setAuthor(newAuthor);
                bookToUpdate.setIsbn(newIsbn);
                bookToUpdate.setPublishDate(newPublishDate);
                System.out.println("Livre mis à jour avec succès.");
            } catch (DateTimeParseException e) {
                System.out.println("Format de date invalide.");
            }
        } else {
            System.out.println("Livre non trouvé.");
        }
    }

    private void borrowBook() {
        scanner.nextLine();
        System.out.println("Entrez l'ID de l'apprenant: ");
        String studentId = scanner.nextLine();
        Student student = library.searchStudent(studentId);
        if (student == null) {
            System.out.println("Apprenant non trouvé.");
            return;
        }
        System.out.println("Titre du livre à emprunter: ");
        String bookTitle = scanner.nextLine();
        Book book = library.searchBook(bookTitle);
        if (book == null) {
            System.out.println("Livre non trouvé.");
            return;
        }
        if (book.getStudent() != null) {
            System.out.println("Ce livre est déjà emprunté.");
            return;
        }
        book.setStudent(student);
        student.getBooks().add(book);
        System.out.println("Livre emprunté avec succès.");
    }

    private void returnBook() {
        scanner.nextLine();
        System.out.println("Entrez l'ID de l'apprenant: ");
        String studentId = scanner.nextLine();
        Student student = library.searchStudent(studentId);
        if (student == null) {
            System.out.println("Apprenant non trouvé.");
            return;
        }
        System.out.println("Titre du livre à retourner: ");
        String bookTitle = scanner.nextLine();
        Book book = library.searchBook(bookTitle);
        if (book == null) {
            System.out.println("Livre non trouvé.");
            return;
        }
        if (book.getStudent() == null || !book.getStudent().getId().equals(studentId)) {
            System.out.println("Ce livre n'a pas été emprunté par cet apprenant.");
            return;
        }
        book.setStudent(null);
        student.getBooks().remove(book);
        System.out.println("Livre retourné avec succès.");
    }
}
