package com.twu.biblioteca;

import java.util.Arrays;
import java.util.Objects;

public class Movie extends Borrowable {
    private String name;
    private int year;
    private String director;
    private int rating;

    public Movie(String name, int year, String director, int rating) {
        this.name = name;
        this.year = year;
        this.director = director;
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Invalid rating: " + rating);
        }
        this.rating = rating;
    }

    public Movie(String name, int year, String director) {
        this(name, year, director, 0);
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRating() {
        return rating;
    }

    public String toString() {
        String rating = String.valueOf(this.rating);
        if (rating.equals("0")) {
            rating = "unrated";
        }
        return String.format("'%s' by %s, %s, rating: %s", name, director, year, rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, director, year);
    }

    @Override
    public boolean equals(Object o) {
        if (o ==  this) return true;
        if (!(o instanceof Movie)) {
            return false;
        }
        Movie movie = (Movie) o;
        return Objects.equals(name, movie.name) &&
                Objects.equals(director, movie.director) &&
                year == movie.year;
    }
}
