package com.twu.biblioteca;

import java.util.HashSet;
import java.util.Scanner;

public class LibraryUI {
    private Library library;
    private final String[] MENU_OPTIONS = { "List Books", "List Movies", "Borrowed Books", "Borrowed Movies", "Quit" };
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
                movieListPage();
                break;
            case 3:
                borrowedBooksPage();
                break;
            case 4:
                borrowedMoviesPage();
                break;
            case 5:
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

    private void movieListPage() {
        printAvailableMovies();
        Movie movie = getMovieSelection();
        if (movie == null || !movie.isAvailable()) {
            System.out.println("That movie is not available.");
            movieListPage();
        } else {
            movie.checkout();
            System.out.println("Thank you! Enjoy the movie.");
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

    private void borrowedMoviesPage() {
        printBorrowedMovies();
        Movie movie = getMovieSelection();
        if (movie == null || movie.isAvailable()) {
            System.out.println("That is not a valid movie to return.");
            borrowedMoviesPage();
        } else {
            movie.checkin();
            System.out.println("Thank you for returning the movie!");
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

    private void printAvailableMovies() {
        System.out.println("====== Available Movies ======");
        HashSet<Movie> movies = library.getAvailableMovies();
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
        System.out.println("Type the movie title to check out or 'q' to go back to main menu");
    }

    private void printBorrowedBooks() {
        System.out.println("====== Borrowed Books ======");
        HashSet<Book> books = library.getBorrowedBooks();
        for (Book book : books) {
            System.out.println(book.toString());
        }
        System.out.println("Type the book title to return or 'q' to go back to main menu: ");
    }

    private void printBorrowedMovies() {
        System.out.println("====== Borrowed Movies ======");
        HashSet<Movie> movies = library.getBorrowedMovies();
        for (Movie movie : movies) {
            System.out.println(movie.toString());
        }
        System.out.println("Type the movie title to return or 'q' to go back to main menu: ");
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

    private Movie getMovieSelection() {
        String userInput = scanner.nextLine();
        if (userInput.equals("q")) {
            mainMenuPage();
        }
        return library.findMovie(userInput);
    }

}
