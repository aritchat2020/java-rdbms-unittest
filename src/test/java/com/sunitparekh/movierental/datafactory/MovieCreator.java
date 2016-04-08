package com.sunitparekh.movierental.datafactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class MovieCreator {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Integer createTheJungleBook(){
        return createMovie(1,"The Jungle Book", Arrays.asList("Action","Adventure","Drama","Family"), LocalDate.of(2016,4,6));
    }

    public Integer createKungFuPanda3(){
        return createMovie(2,"Kung Fu Panda 3", Arrays.asList("Animation"), LocalDate.of(2016,4,1));
    }

    public Integer createBatmanVsSupermanDawnofJustice(){
        return createMovie(3,"Batman v Superman: Dawn of Justice", Arrays.asList("Action","Adventure","Scifi","Fantasy"), LocalDate.of(2016,3,25));
    }

    public Integer createStarWarsTheForceAwakens(){
        return createMovie(4,"Star Wars: The Force Awakens", Arrays.asList("Scifi","Fantasy"), LocalDate.of(2015,12,25));
    }

    public Integer createMovie(Integer id, String name, List<String> genres, LocalDate releaseDate) {
        Date releaseDateutil = Date.from(releaseDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String sql = "INSERT INTO MOVIES(MOVIE_ID,MOVIE_NAME,RELEASE_DATE) values(?,?,?)";
        return jdbcTemplate.update(sql,id,name,releaseDateutil);
    }

    public void cleanup() {
        jdbcTemplate.update("DELETE FROM MOVIES");
    }
}
