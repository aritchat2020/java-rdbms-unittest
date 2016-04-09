package com.sunitparekh.movierental.controller;

import com.sunitparekh.movierental.repository.MovieRepository;
import com.sunitparekh.movierental.view.MovieView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    @Autowired
    public MovieRepository repository;

    @RequestMapping("/movies")
    public List<MovieView> index() {
        return repository.findAllMovies().stream().map(MovieView::new).collect(Collectors.toList());
    }

}
