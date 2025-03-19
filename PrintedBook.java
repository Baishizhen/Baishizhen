package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintedBook extends Book {
    private boolean isBorrowed;

    public PrintedBook() {
    }

    public PrintedBook(String title, String author, int ISBN, boolean isBorrowed) {
        super(title, author, ISBN);
        this.isBorrowed = isBorrowed;
    }

    public void addBook(ArrayList<Book> book) {
        Scanner input = new Scanner(System.in);
        PrintedBook printedBook = new PrintedBook();

        System.out.print("Enter The Title：");
        String title = input.nextLine();
        printedBook.setTitle(title);

        System.out.print("Enter The Author: ");
        String author = input.nextLine();
        printedBook.setAuthor(author);

        System.out.print("Enter The ISBN: ");
        int ISBN = input.nextInt();
        printedBook.setISBN(ISBN);

        printedBook.setBorrowed(true);

        System.out.printf("\"%s\" has been add to the System\n", printedBook.getTitle());
        book.add(printedBook);
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public boolean getBorrowed() {
        return isBorrowed;
    }

    public void isBorrowed(ArrayList<Book> book) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Select an option:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Exit");
            int option = input.nextInt();
            input.nextLine();
            if (option == 1) {
                System.out.print("Enter the ISBN of the book you wish to borrow: ");
                int ISBN = input.nextInt();
                for (int i = 0; i < book.size(); i++) {
                    if (ISBN == book.get(i).getISBN()) {
                        this.isBorrowed = false;
                        System.out.println("Success! The book has been borrowed.");
                        return;
                    }
                    flag = false;
                }
                System.out.println("Oops! Borrowing was unsuccessful. Please try again.");
                return;
            }
            if (option == 2) {
                System.out.print("Enter the ISBN of the book you wish to return: ");
                int ISBN = input.nextInt();
                for (int i = 0; i < book.size(); i++) {
                    if(((ISBN == book.get(i).getISBN()) && (book.get(i) instanceof PrintedBook))
                            && (((PrintedBook) book.get(i)).getBorrowed() == true)){
                        System.out.println("Oops! This book was never borrowed, so it cannot be returned.");
                        return;
                    }
                    else if ((ISBN == book.get(i).getISBN()) && (((PrintedBook) book.get(i)).getBorrowed() == false)) {
                        this.isBorrowed = true;
                        System.out.println("Success! The book has been return.");
                        return;
                    }
                    flag = false;
                }
                System.out.println("Oops! Return was unsuccessful. Please try again.");
                return;
            }
        }
    }
}