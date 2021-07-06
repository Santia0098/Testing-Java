package com.platzi.javatests.movies.service;

import com.platzi.javatests.movies.data.MovieRepository;
import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
                Arrays.asList(
                        new Movie(1, "batman", 122, Genre.COMEDY, "pedro"),
                        new Movie(2, "deadpool", 125, Genre.ACTION, "sanches"),
                        new Movie(5, "deadpoo2", 125, Genre.ACTION, "peres"),
                        new Movie(3, "flash", 121, Genre.DRAMA, "del"),
                        new Movie(4, "avengers", 120, Genre.HORROR, "toro"),
                        new Movie(6, "Justice", 122, Genre.COMEDY, "guillermo")
                )
        );

        movieService = new MovieService(movieRepository);
    }

    @Test
    public void return_movies_by_genre() {

        Collection<Movie> movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(3, 6)));
    }

    @Test
    public void return_movies_by_length() {

        Collection<Movie> movies = movieService.findMoviesByLength(125);

        assertThat(getMovieIds(movies), CoreMatchers.is(Arrays.asList(1,3,4,6)));
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

    @Test
    public void returnMovieByName(){
        Collection<Movie> movies = movieService.findMoviesByName("matrix");
        assertThat(getMovieIds(movies), is(Arrays.asList(7, 9, 10)));
    }

    @Test
    public void returnMovieByDirector(){
        Collection<Movie> movies = movieService.findMoviesByDirector("nolan");
        assertThat(getMovieIds(movies), is(Arrays.asList(1, 2, 8)));
    }


}