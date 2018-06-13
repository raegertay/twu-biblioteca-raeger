package com.twu.biblioteca;

import java.util.HashSet;
import java.util.Scanner;

public class LibraryUI {
    private Library library;
    private final String[] MENU_OPTIONS = { "List Books", "Borrowed Books", "Quit" };
    private final Scanner scanner = new Scanner(System.in);

    public LibraryUI(Library library) {
        this.library = library;
    }

    public void start() {
        printGreeting();
        mainMenuPage();
    }

    private void mainMenuPage() {
        printMenu();
        int userInput = getMenuSelection();
        switch(userInput) {
            case 1:
                bookListPage();
                break;
            case 2:
                borrowedBooksPage();
                break;
            case 3:
                System.out.println("Goodbye!");
                System.exit(0);
            default:
                System.out.println("Select a valid option!");
                mainMenuPage();
        }
    }

    private void bookListPage() {
        printAvailableBooks();
        Book book = getBookSelection();
        if (book == null || !book.isAvailable()) {
            System.out.println("That book is not available.");
            bookListPage();
        } else {
            book.checkout();
            System.out.println("Thank you! Enjoy the book.");
            mainMenuPage();
        }
    }

    private void borrowedBooksPage() {
        printBorrowedBooks();
        Book book = getBookSelection();
        if (book == null || book.isAvailable()) {
            System.out.println("That is not a valid book to return.");
            borrowedBooksPage();
        } else {
            book.checkin();
            System.out.println("Thank you for returning the book!");
            mainMenuPage();
        }
    }

    private void printGreeting() {
        System.out.println("Welcome to Biblioteca!");
    }

    private void printMenu() {
        System.out.println("====== Main Menu ======");

        for (int i = 0; i < MENU_OPTIONS.length; i++) {
            System.out.println((i+1) + ". " + MENU_OPTIONS[i]);
        }
        System.out.println("(Choose a number from 1-" + MENU_OPTIONS.length + ")");
    }

    private void printAvailableBooks() {
        System.out.println("====== Available Books ======");
        HashSet<Book> books = library.getAvailableBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("Type the book title to check out or 'q' to go back to main menu: ");
    }

    private void printBorrowedBooks() {
        System.out.println("====== Borrowed Books ======");
        HashSet<Book> books = library.getBorrowedBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("Type the book title to return or 'q' to go back to main menu: ");
    }

    private int getMenuSelection() {
        int userSelection = scanner.nextInt();
        scanner.nextLine();
        return userSelection;
    }

    private Book getBookSelection() {
        String userInput = scanner.nextLine();
        if (userInput.equals("q")) {
            mainMenuPage();
        }
        return library.findBook(userInput);
    }


}
