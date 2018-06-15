package com.twu.biblioteca;

import java.util.Arrays;
import java.util.HashSet;

public class BibliotecaApp {

    public static void main(String[] args) {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Movie movie1 = new Movie("Movie1", 2001, "Director1", 1);
        Movie movie2 = new Movie("Movie2", 2001, "Director2", 2);
        Movie movie3 = new Movie("Movie3", 2001, "Director3", 3);
        HashSet<Movie> movies = new HashSet<>(Arrays.asList(movie1, movie2, movie3));
        Library library = new Library(books, movies);
        LibraryUI libraryUI = new LibraryUI(library);
        libraryUI.start();
    }
}
