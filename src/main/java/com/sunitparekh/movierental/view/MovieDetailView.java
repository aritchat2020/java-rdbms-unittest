package com.sunitparekh.movierental.view;

import com.sunitparekh.movierental.model.Movie;

import java.time.format.DateTimeFormatter;

public class MovieDetailView extends MovieLiteView {

    public MovieDetailView(Movie movie) {
        super(movie);
    }

    public String getReleaseDate() {
        return DateTimeFormatter.ISO_DATE.format(movie.getReleaseDate());
    }

}
