package com.sunitparekh.movierental.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sunitparekh.movierental.model.Movie;

import java.time.format.DateTimeFormatter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MovieView {

    private Movie movie;

    public MovieView(Movie movie) {
        this.movie = movie;
    }

    public String getName() { return movie.getName(); }
    public Long getId() { return Long.valueOf(movie.getId()); }

    public String getReleaseDate() {
        return DateTimeFormatter.ISO_DATE.format(movie.getReleaseDate());
    }

}
