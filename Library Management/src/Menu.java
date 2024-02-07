import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    // fields
    Scanner sc = new Scanner(System.in);
    Library library = new Library();
    SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");

    // methode for display menu
    public void displayMenu() throws ParseException {
        int choice;
        String title, author, isbn;
        do {
            System.out.println("Enter votre choix: ");
            choice = sc.nextInt();
            System.out.println("***********************************************************************");
            System.out.println("********   Enaa-Lib : Application De Gestation De Bibliothèque   ********");
            System.out.println("***********************************************************************");
            System.out.println("********                     1: Ajouter Livre                  ********");
            System.out.println("********                     2: Supprimer Livre                ********");
            System.out.println("********                     3: Rechercher Livre               ********");
            System.out.println("********                     4: Modifier Livre                 ********");
            System.out.println("***********************************************************************");
            System.out.println("***********************************************************************");
            switch (choice){
                case 1:
                    System.out.println("Title: ");
                    title = sc.nextLine();
                    System.out.println("Author: ");
                    author = sc.nextLine();
                    System.out.println("ISBN: ");
                    isbn = sc.nextLine();
                    System.out.println("Date Publication: ");
                    String publishDate = sc.next();
                    Date datePub = myFormat.parse(publishDate);
                    Book book = new Book(title, author, isbn, datePub);
                    library.addBook(book);
                    break;
                case 2, 3:
                    System.out.println("Entrez le titre du livre: ");
                    title = sc.nextLine();
                    if (choice == 2){
                        library.delBook(library.searchBook(title));
                    }
                    else {
                        library.searchBook(title);
                    }
                    break;
                case 4:
                    break;
            }
        }while (choice != 5);
    }
}
