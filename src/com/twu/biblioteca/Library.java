package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Library {
    private HashSet<Book> books;

    public Library(HashSet<Book> books) {
        this.books = books;
    }

    public Library() {
        this(new HashSet<Book>());
    };


    public HashSet<Book> getAvailableBooks() {
        HashSet<Book> availableBooks = new HashSet<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
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


    public Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }
}
