package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Objects;

public class Book extends Borrowable {
    private String title;
    private String[] author;
    private int year;

    public Book(String title, String author, int year) {
        this(title, new String[] { author }, year);
    }

    public Book(String title, String[] author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String toString() {
        String authors = String.join(", ", author);
        return String.format("'%s' by %s, %s", title, authors, year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, Arrays.hashCode(author), year);
    }

    @Override
    public boolean equals(Object o) {
        if (o ==  this) return true;
        if (!(o instanceof Book)) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                year == book.year;
    }
}
