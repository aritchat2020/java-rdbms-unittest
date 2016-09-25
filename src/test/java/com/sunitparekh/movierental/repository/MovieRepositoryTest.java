package com.sunitparekh.movierental.repository;

import com.sunitparekh.movierental.model.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private MovieRepository repository;

    @Test
    public void findByTitleLike(){
        entityManager.persist(new Movie("Star Wars: The Force Awakens", LocalDate.of(2015,12,25)));
        entityManager.persist(new Movie("The Jungle Book", LocalDate.of(2016,4,6)));

        List<Movie> movies = repository.findByTitleLike("Force");

        assertEquals(1,movies.size());
        assertEquals("Star Wars: The Force Awakens",movies.get(0).getName());
    }

    @Test
    public void findByReleaseYear(){
        entityManager.persist(new Movie("Star Wars: The Force Awakens", LocalDate.of(2015,12,25)));
        entityManager.persist(new Movie("The Jungle Book", LocalDate.of(2016,4,6)));

        List<Movie> movies = repository.findByReleaseYear(2016);

        assertEquals(1,movies.size());
        assertEquals("The Jungle Book",movies.get(0).getName());
    }

}