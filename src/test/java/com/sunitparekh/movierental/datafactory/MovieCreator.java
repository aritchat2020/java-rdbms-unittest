package com.sunitparekh.movierental.datafactory;

import com.sunitparekh.movierental.model.Movie;
import com.sunitparekh.movierental.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MovieCreator {

    @Autowired
    MovieRepository repository;

    public Long createTheJungleBook(){
        return createMovie("The Jungle Book", LocalDate.of(2016,4,6));
    }

    public Long createKungFuPanda3(){
        return createMovie("Kung Fu Panda 3", LocalDate.of(2016,4,1));
    }

    public Long createBatmanVsSupermanDawnofJustice(){
        return createMovie("Batman v Superman: Dawn of Justice", LocalDate.of(2016,3,25));
    }

    public Long createStarWarsTheForceAwakens(){
        return createMovie("Star Wars: The Force Awakens", LocalDate.of(2015,12,25));
    }

    public Long createMovie(String name, LocalDate releaseDate) {
        Movie movie = new Movie(name, releaseDate);
        repository.save(movie);
        return  movie.getId();
    }

    public void cleanup() {
        repository.deleteAll();
    }


    public Long createMovieWithoutName() {
        return createMovie(null,LocalDate.of(2015,12,25));
    }
}
