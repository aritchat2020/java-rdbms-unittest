package com.sunitparekh.movierental.service;

import com.sunitparekh.movierental.exceptions.ObjectNotFoundException;
import com.sunitparekh.movierental.model.Movie;
import com.sunitparekh.movierental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    public MovieRepository repository;


    public List<Movie> findAllMovies() {
        return (List<Movie>) repository.findAll();
    }

    public Movie getMovie(Long id) throws ObjectNotFoundException {
        Movie movie = repository.findOne(id);
        if (movie == null) throw new ObjectNotFoundException("Movie with id " + id + ", does not exists.");
        return movie;
    }
}
