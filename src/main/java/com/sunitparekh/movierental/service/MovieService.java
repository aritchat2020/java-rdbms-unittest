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
        return repository.findAllMovies();
    }

    public Movie getMovie(Integer id) throws ObjectNotFoundException {
        return repository.getMovie(id);
    }
}
