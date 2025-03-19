package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> book = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Book bookObject = new Book();
        boolean flag = true;
        while (flag) {
            System.out.println("-----Welcome to the Library Management System-----");
            System.out.println("Please select an option:");
            System.out.println("1. Add a new book");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book");
            System.out.println("4. Borrow/Return a book");
            System.out.println("5. Delete a book");
            System.out.println("6. Exit");
            System.out.print("Please enter your choice: ");
            int option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    bookObject.addBook(book);
                    break;
                case 2:
                    bookObject.displayBook(book);
                    break;
                case 3:
                    bookObject.searchBook(book);
                    break;
                case 4:
                    PrintedBook b = new PrintedBook();
                    b.isBorrowed(book);
                    break;
                case 5:
                    bookObject.deleteBook(book);
                    break;
                case 6:
                    System.out.println("The program has exited.");
                    System.exit(0);
                default:
                    flag = false;
                    break;
            }
        }
    }
}