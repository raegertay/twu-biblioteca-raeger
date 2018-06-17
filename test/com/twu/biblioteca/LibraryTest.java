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
        book3.checkout(null);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(new HashSet<User>(), books, new HashSet<Movie>());
        assertEquals(new HashSet<Book>(Arrays.asList(book1, book2)), library.getAvailableBooks());
    }

    @Test
    public void getBorrowedBooksShouldReturnAllBorrowedBooks() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        book3.checkout(null);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(new HashSet<User>(), books, new HashSet<Movie>());
        assertEquals(new HashSet<Book>(Arrays.asList(book3)), library.getBorrowedBooks());
    }

    @Test
    public void findBookShouldFindBookGivenTitle() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(new HashSet<User>(), books, new HashSet<Movie>());
        assertEquals(book3, library.findBook("book3"));
    }

    @Test
    public void findBookShouldReturnNullIfBookDoesNotExist() {
        Book book1 = new Book("book1", "author1", 2001);
        Book book2 = new Book("book2", "author2", 2002);
        Book book3 = new Book("book3", "author3", 2003);
        HashSet<Book> books = new HashSet<>(Arrays.asList(book1, book2, book3));
        Library library = new Library(new HashSet<User>(), books, new HashSet<Movie>());
        assertEquals(null, library.findBook("book4"));
    }

    @Test
    public void getAvailableMoviesShouldReturnAllAvailableMovies() {
        Movie movie1 = new Movie("Movie1", 2001, "Director1", 1);
        Movie movie2 = new Movie("Movie2", 2001, "Director2", 2);
        Movie movie3 = new Movie("Movie3", 2001, "Director3", 3);
        movie3.checkout(null);
        HashSet<Movie> movies = new HashSet<>(Arrays.asList(movie1, movie2, movie3));
        Library library = new Library(new HashSet<User>(), new HashSet<Book>(), movies);
        assertEquals(new HashSet<Movie>(Arrays.asList(movie1, movie2)), library.getAvailableMovies());
    }

    @Test
    public void getBorrowedMoviesShouldReturnAllBorrowedMovies() {
        Movie movie1 = new Movie("Movie1", 2001, "Director1", 1);
        Movie movie2 = new Movie("Movie2", 2001, "Director2", 2);
        Movie movie3 = new Movie("Movie3", 2001, "Director3", 3);
        movie3.checkout(null);
        HashSet<Movie> movies = new HashSet<>(Arrays.asList(movie1, movie2, movie3));
        Library library = new Library(new HashSet<User>(), new HashSet<Book>(), movies);
        assertEquals(new HashSet<Movie>(Arrays.asList(movie3)), library.getBorrowedMovies());
    }

    @Test
    public void findMovieShouldFindMovieGivenName() {
        Movie movie1 = new Movie("Movie1", 2001, "Director1", 1);
        Movie movie2 = new Movie("Movie2", 2001, "Director2", 2);
        Movie movie3 = new Movie("Movie3", 2001, "Director3", 3);
        HashSet<Movie> movies = new HashSet<>(Arrays.asList(movie1, movie2, movie3));
        Library library = new Library(new HashSet<User>(), new HashSet<Book>(), movies);
        assertEquals(movie3, library.findMovie("Movie3"));
    }

    @Test
    public void getUsersShouldReturnAllUsers() {
        User user1 = new User("000-0001", "abc123", "Tom", "tom@email.com", "91234567");
        User user2 = new User("000-0002", "abc123", "Alan", "alan@email.com", "98765432");
        User user3 = new User("000-0003", "abc123", "Mike", "mike@email.com", "95431675");
        HashSet<User> users = new HashSet<>(Arrays.asList(user1, user2, user3));
        Library library = new Library(users, new HashSet<Book>(), new HashSet<Movie>());
        assertEquals(users, library.getUsers());
    }
}
