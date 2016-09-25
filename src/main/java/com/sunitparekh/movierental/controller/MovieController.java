package com.sunitparekh.movierental.controller;

import com.sunitparekh.movierental.exceptions.ObjectNotFoundException;
import com.sunitparekh.movierental.service.MovieService;
import com.sunitparekh.movierental.view.MovieDetailView;
import com.sunitparekh.movierental.view.MovieLiteView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MovieController {

    @Autowired
    public MovieService service;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<MovieLiteView> getMovies() {
        return service.findAllMovies().stream().map(MovieLiteView::new).collect(Collectors.toList());
    }

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    public MovieDetailView getMovies(@PathVariable("id") Long id) throws ObjectNotFoundException {
        return new MovieDetailView(service.getMovie(id));
    }

}
