package com.sunitparekh.movierental.model;

import java.time.LocalDate;

public class Movie {
    private Integer id;
    private String name;
    private LocalDate releaseDate;

    public Movie(Integer id, String name, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Integer getId() {
        return id;
    }
}
