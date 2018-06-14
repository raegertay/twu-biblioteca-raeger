package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionIfRatingIsInvalid() {
        Movie movie = new Movie("Movie Name", 2012, "Director Name", 12);
    }

    @Test
    public void getNameShouldReturnMovieName() {
        Movie movie = new Movie("Movie Name", 2012, "Director Name", 8);
        assertEquals("Movie Name", movie.getName());
    }

    @Test
    public void getYearShouldReturnMovieYear() {
        Movie movie = new Movie("Movie Name", 2012, "Director Name", 8);
        assertEquals(2012, movie.getYear());
    }

    @Test
    public void getDirectorShouldReturnMovieDirector() {
        Movie movie = new Movie("Movie Name", 2012, "Director Name", 8);
        assertEquals("Director Name", movie.getDirector());
    }

    @Test
    public void getRatingShouldReturnMovieRating() {
        Movie movie = new Movie("Movie Name", 2012, "Director Name", 8);
        assertEquals(8, movie.getRating());
    }

    @Test
    public void toStringShouldPrintMovieNameDirectorYearAndRating() {
        Movie movie = new Movie("Movie Name", 2012, "Director Name");
        assertEquals("'Movie Name' by Director Name, 2012, rating: unrated", movie.toString());
    }

    @Test
    public void movieWithSameNameDirectorAndYearShouldBeEqual() {
        Movie movie1 = new Movie("Movie Name", 2012, "Director Name");
        Movie movie2 = new Movie("Movie Name", 2012, "Director Name");
        assertEquals(movie1, movie2);
    }
}
