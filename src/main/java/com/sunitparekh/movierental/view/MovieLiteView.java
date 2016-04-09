package com.sunitparekh.movierental.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sunitparekh.movierental.model.Movie;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MovieLiteView {

    protected Movie movie;

    public MovieLiteView(Movie movie) {
        this.movie = movie;
    }

    public String getName() { return movie.getName(); }
    public Long getId() { return Long.valueOf(movie.getId()); }

    public String getReleaseYear() {
        return String.valueOf(movie.getReleaseDate().getYear());
    }

}
