package com.sunitparekh.movierental.repository;

import com.sunitparekh.movierental.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class MovieRepository2 {

    @Autowired
    EntityManager manager;

    public List<Movie> findAll() {
        List<Movie> movies = manager.createQuery("from Movie", Movie.class)
                .getResultList();
        return movies;
    }

    public Movie findOne(int id) {
        String sql = "SELECT m FROM Movie m WHERE m.id = :id";
        Movie movie = manager.createQuery(sql, Movie.class)
                .setParameter("id", id)
                .getSingleResult();
        return movie;
    }
}
