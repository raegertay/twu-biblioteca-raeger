package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class BookTest {

    @Test
    public void getTitleShouldReturnTitle() {
        String title = "TDD By Example";
        String author = "Kent Beck";
        int year = 2000;
        Book book = new Book(title, author, year);
        assertEquals(title, book.getTitle());
    }

    @Test
    public void getAuthorShouldReturnAuthor() {
        String title = "TDD By Example";
        String author = "Kent Beck";
        int year = 2000;
        Book book = new Book(title, author, year);
        assertArrayEquals(new String[] { author }, book.getAuthor());
    }

    @Test
    public void getYearShouldReturnYear() {
        String title = "TDD By Example";
        String author = "Kent Beck";
        int year = 2000;
        Book book = new Book(title, author, year);
        assertEquals(year, book.getYear());
    }

    @Test
    public void getAuthorShouldReturnAllAuthorsIfMoreThanOne() {
        String title = "Head First Java";
        String[] author = {"Kathy Sierra", "Bert Bates"};
        int year = 2005;
        Book book = new Book(title, author, year);
        assertArrayEquals(author, book.getAuthor());
    }

    @Test
    public void toStringShouldPrintTitleAndAuthorAndYear() {
        String title = "Head First Java";
        String[] author = {"Kathy Sierra", "Bert Bates"};
        int year = 2005;
        Book book = new Book(title, author, year);
        assertEquals("'Head First Java' by Kathy Sierra, Bert Bates, 2005", book.toString());
    }

    @Test
    public void newBookShouldBeAvailable() {
        Book book = new Book("TDD By Example", "Kent Beck", 2000);
        assertEquals(true, book.isAvailable());
    }

    @Test
    public void bookShouldNotBeAvailableAfterCheckout() {
        Book book = new Book("TDD By Example", "Kent Beck", 2000);
        book.checkout(null);
        assertEquals(false, book.isAvailable());
    }

    @Test
    public void bookShouldBeAvailableAfterCheckin() {
        Book book = new Book("TDD By Example", "Kent Beck", 2000);
        book.checkout(null);
        book.checkin();
        assertEquals(true, book.isAvailable());
    }

    @Test
    public void booksWithSameTitleAuthorAndYearShouldBeEqual() {
        Book book1 = new Book("TDD By Example", "Kent Beck", 2000);
        Book book2 = new Book("TDD By Example", "Kent Beck", 2000);
        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void getBorrowerShouldReturnTheUserAfterCheckout() {
        Book book = new Book("TDD By Example", "Kent Beck", 2000);
        User user = new User("000-0001", "abc123", "Tom", "tom@email.com", "91234567");
        book.checkout(user);
        assertEquals(user, book.getBorrower());
    }

    @Test
    public void getBorrowerShouldReturnNullAfterCheckIn() {
        Book book = new Book("TDD By Example", "Kent Beck", 2000);
        User user = new User("000-0001", "abc123", "Tom", "tom@email.com", "91234567");
        book.checkout(user);
        book.checkin();
        assertEquals(null, book.getBorrower());
    }
}
