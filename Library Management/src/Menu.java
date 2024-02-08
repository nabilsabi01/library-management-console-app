import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    // fields
    Library library;
    Student student;
    Book book;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");;
    int choice;
    String title, author, isbn; //, name, address, id;
    Date dp = new Date();

    public Menu() {

    }

    // methode for display menu for manage students
    public  void menuManageStudents() {
        do {
            Scanner sc1  = new Scanner(System.in);
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
            choice = sc1.nextInt();
            switch (choice){
                case 1:
                    Scanner sc  = new Scanner(System.in);
                    System.out.println("Nom:");
                    String name = sc.nextLine();
                    System.out.println("Adresse:");
                    String address = sc.nextLine();
                    System.out.println("ID:");
                    String id = sc.nextLine();
                    student = new Student(name, address, id);
                    library.addStudent(student);
                    break;
//                case 2:
//                    System.out.println("Entrez le id de apprenant: ");
//                    id = sc.nextLine();
//                    if (library.searchStudent(id) != null){
//                        library.delStudent(id);
//                    }
//                    break;
                case 3:
                    library.displayAllStudents();
                    break;

                case 4:
                    menuMain();
                    break;

            }
        }while (choice != 5);
    }

    // methode for display menu for manage books
    public void menuManageBooks() {
        do {
            Scanner sc  = new Scanner(System.in);
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
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.println("Title:");
                    title = sc.next();
                    System.out.println("Author:");
                    author = sc.next();
                    System.out.println("ISBN:");
                    isbn = sc.next();
                    System.out.println("Date Publication:");
                    try {
                        dp = df.parse(sc.next());
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    book = new Book(title, author, isbn, dp);
                    library.addBook(book);
                    break;
                case 2, 3:
                    System.out.println("Titre du livre: ");
                    title = sc.nextLine();
                    if (choice == 2){
                        library.delBook(library.searchBook(title));
                    }
                    else {
                        library.searchBook(title);
                    }
                    break;
                case 5:
                    library.displayAllBooks();
                    break;
                case 6:
                    menuMain();
                    break;
            }
        }while (choice != 7);
    }

    // menu main
    public void menuMain() {
        do {
            Scanner sc  = new Scanner(System.in);
            System.out.println("******************************************************************************");
            System.out.println("********         Enaa-Lib : Gestion De Bibliothèque                   ******* ");
            System.out.println("******************************************************************************");
            System.out.println("********                    1: Gère Les Livres                        ********");
            System.out.println("********                    2: Gère Les Apprenants                    ********");
            System.out.println("********                    3: Emprunté Un Livre                      ********");
            System.out.println("********                    4: Retour Un Livre                        ********");
            System.out.println("******************************************************************************");
            System.out.println("******************************************************************************");
            System.out.println("Enter votre choix: ");
            choice = sc.nextInt();
            switch (choice){
                case 1:
                    menuManageBooks();
                    break;
                case 2:
                    menuManageStudents();
                    break;
                case 3:
                    System.out.println("Enter le title de livre: ");
                    title = sc.nextLine();
                    break;
            }
        }while (choice != 4);
    }

}
