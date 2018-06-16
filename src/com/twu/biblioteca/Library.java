package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Library {
    private HashSet<User> users;
    private HashSet<Book> books;
    private HashSet<Movie> movies;

    public Library(HashSet<User> users, HashSet<Book> books, HashSet<Movie> movies) {
        this.users = users;
        this.books = books;
        this.movies = movies;
    }

    public HashSet<Book> getAvailableBooks() {
        HashSet<Book> availableBooks = new HashSet<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    public HashSet<Movie> getAvailableMovies() {
        HashSet<Movie> availableMovies = new HashSet<>();
        for (Movie movie : movies) {
            if (movie.isAvailable()) {
                availableMovies.add(movie);
            }
        }
        return availableMovies;
    }

    public HashSet<Book> getBorrowedBooks() {
        HashSet<Book> borrowedBooks = new HashSet<>();
        for (Book book : books) {
            if (!book.isAvailable()) {
                borrowedBooks.add(book);
            }
        }
        return borrowedBooks;
    }

    public HashSet<Movie> getBorrowedMovies() {
        HashSet<Movie> borrowedMovies = new HashSet<>();
        for (Movie movie : movies) {
            if (!movie.isAvailable()) {
                borrowedMovies.add(movie);
            }
        }
        return borrowedMovies;
    }


    public Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }

    public Movie findMovie(String movieName) {
        for (Movie movie : movies) {
            if (movie.getName().equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    public HashSet<User> getUsers() {
        return users;
    }
}
