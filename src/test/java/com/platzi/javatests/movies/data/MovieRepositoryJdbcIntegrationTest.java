package com.platzi.javatests.movies.data;

import com.platzi.javatests.movies.model.Genre;
import com.platzi.javatests.movies.model.Movie;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collector;
import java.util.stream.Collectors.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryJdbcIntegrationTest {
    MovieRepositoryJdbc movieRepositoryJdbc;
    DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts.sql-scritps/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        movieRepositoryJdbc = new MovieRepositoryJdbc(jdbcTemplate);

    }

    @Test
    public void load_all_movies() throws SQLException {


        Collection<Movie> movies = movieRepositoryJdbc.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie("dark", 152, Genre.ACTION, "guiilermo"),
                new Movie("dark", 113, Genre.THRILLER, "del"),
                new Movie("dark", 136, Genre.ACTION, "Toro")
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepositoryJdbc.findById(2);

        assertThat(movie, is(new Movie(2, "Dark", 152, Genre.ACTION, "pepe")));

    }

    @Test
    public void insert_a_movie() {

        Movie movie = new Movie("Joker", 130, Genre.THRILLER, "Guillermo del toro");
        movieRepositoryJdbc.saveOrUpdate(movie);

        Movie movieExpected = movieRepositoryJdbc.findById(4);
        assertThat(movieExpected, is(new Movie(4, "Joker", 130, Genre.THRILLER, "pepe")));
    }

    @After

    public void tearDown() throws SQLException {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}