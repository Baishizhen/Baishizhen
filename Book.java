package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    protected String title;
    protected String author;
    protected int ISBN;

    public Book() {
    }

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    public void addBook(ArrayList<Book> book) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Select the category of the new book:");
            System.out.println("1. Printed Book");
            System.out.println("2. Electronic Book");
            System.out.println("3. Exit");
            System.out.print("Enter your option: ");
            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                Book printedBook = new PrintedBook();
                printedBook.addBook(book);
            } else if (option == 2) {
                Book eBook = new ElectronicBook();
                eBook.addBook(book);
            } else if (option == 3) {
                return;
            } else {
                flag = true;
            }
        }
    }

    public void displayBook(ArrayList<Book> book) {
        int count = 0;
        if (book.isEmpty()) {
            System.out.println("Library is Empty");
        } else {
            System.out.println("Number\tISBN\t\tTitle\t\t\tAuthor\t\tStatus");
            for (int i = 0; i < book.size(); i++) {
                count++;
                if (book.get(i) instanceof PrintedBook) {
                    PrintedBook b = (PrintedBook) book.get(i);
                    System.out.printf("#%d\t\t%s\t\t%s\t\t%s\t\t%s\n", count, b.getISBN(),
                            b.getTitle(), b.getAuthor(), b.getBorrowed());
                } else if (book.get(i) instanceof ElectronicBook) {
                    ElectronicBook e = (ElectronicBook) book.get(i);
                    System.out.printf("#%d\t\t%s\t\t%s\t\t%s\n", count, e.getISBN(),
                            e.getTitle(), e.getAuthor());
                }
            }
        }
    }

    public void searchBook(ArrayList<Book> book) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("Enter the ISBN or Book Title to look up the book: ");
            String input = scanner.nextLine();
            for (int i = 0; i < book.size(); i++) {
                int count = 0;
                count++;
                if (input.equals(book.get(i).getTitle()) || (String.valueOf(book.get(i).getISBN()).equals(input))) {
                    System.out.println("Number\tISBN\t\tTitle\t\t\tAuthor\t\tStatus");
                    if (book.get(i) instanceof PrintedBook) {
                        PrintedBook b = (PrintedBook) book.get(i);
                        System.out.printf("#%d\t\t%s\t\t%s\t\t%s\t\t%s\n", count, b.getISBN(),
                                b.getTitle(), b.getAuthor(), b.getBorrowed());
                        return;
                    } else if (book.get(i) instanceof ElectronicBook) {
                        ElectronicBook e = (ElectronicBook) book.get(i);
                        System.out.printf("#%d\t\t%s\t\t%s\t\t%s\n", count, e.getISBN(),
                                e.getTitle(), e.getAuthor());
                        return;
                    }
                    flag = false;
                }
            }
            System.out.println("No matching book found for the given ISBN or title.");
            flag = false;
        }
    }

    public void deleteBook(ArrayList<Book> book) {
        Scanner input = new Scanner(System.in);
        if (book.isEmpty()) {
            System.out.println("Library is Empty");
        } else {
            System.out.print("Enter the ISBN of the book you want to delete: ");
            int ISBN = input.nextInt();
            for (int i = 0; i < book.size(); i++) {
                if (book.get(i).getISBN() == ISBN) {
                    book.remove(i);
                    break;
                }
                if (ISBN != book.get(i).getISBN()) {
                    System.out.println("ISBN is not Found");
                    break;
                }

            }
        }
    }

    //Setter and Getter
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}