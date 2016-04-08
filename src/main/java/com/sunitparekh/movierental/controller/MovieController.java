package com.sunitparekh.movierental.controller;

import com.sunitparekh.movierental.model.Movie;
import com.sunitparekh.movierental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    public MovieRepository repository;

    @RequestMapping("/movies")
    public List<Movie> index() {
        return repository.findAllMovies();
    }

}
