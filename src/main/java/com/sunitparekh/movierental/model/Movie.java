package com.sunitparekh.movierental.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MOVIES")
public class Movie {

    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "MOVIE_NAME")
    private String name;

    @Column(name = "RELEASE_DATE")
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(String name, LocalDate releaseDate) {
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Long getId() {
        return id;
    }
}
