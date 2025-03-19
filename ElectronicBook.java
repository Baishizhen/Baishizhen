package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectronicBook extends Book {
    public ElectronicBook() {
    }

    public ElectronicBook(String title, String author, int ISBN) {
        super(title, author, ISBN);
    }

    public void addBook(ArrayList<Book> book) {
        Scanner input = new Scanner(System.in);
        ElectronicBook eBook = new ElectronicBook();

        System.out.print("Please Enter The Title：");
        String title = input.nextLine();
        eBook.setTitle(title);

        System.out.print("Please Enter The Author: ");
        String author = input.nextLine();
        eBook.setAuthor(author);

        System.out.print("Please Enter The ISBN: ");
        int ISBN = input.nextInt();
        eBook.setISBN(ISBN);

        System.out.printf("\"%s\" has been add to the System\n", eBook.getTitle());
        book.add(eBook);
    }
}