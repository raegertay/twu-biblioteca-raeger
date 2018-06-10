package com.twu.biblioteca;


import org.junit.Before;
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
}
