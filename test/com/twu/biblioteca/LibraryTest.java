package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    @Test
    public void getAvailableBooksShouldReturnAllAvailableBooks() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        book3.checkout();
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(books);
        assertEquals(new HashSet<Book>(Arrays.asList(book1, book2)), library.getAvailableBooks());
    }

    @Test
    public void getBorrowedBooksShouldReturnAllBorrowedBooks() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        book3.checkout();
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(books);
        assertEquals(new HashSet<Book>(Arrays.asList(book3)), library.getBorrowedBooks());
    }

    @Test
    public void findBookShouldFindBookGivenTitle() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(books);
        assertEquals(book3, library.findBook("book3"));
    }

    @Test
    public void findBookShouldReturnNullIfBookDoesNotExist() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(books);
        assertEquals(null, library.findBook("book4"));
    }
}
