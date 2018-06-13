package com.twu.biblioteca;

import java.util.Arrays;
import java.util.HashSet;

public class BibliotecaApp {

    public static void main(String[] args) {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(books);
        LibraryUI libraryUI = new LibraryUI(library);
        libraryUI.start();
    }
}
