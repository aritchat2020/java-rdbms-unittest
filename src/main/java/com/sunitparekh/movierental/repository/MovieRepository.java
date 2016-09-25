package com.sunitparekh.movierental.repository;


import com.sun.javafx.binding.StringFormatter;
import com.sunitparekh.movierental.exceptions.ObjectNotFoundException;
import com.sunitparekh.movierental.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class MovieRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> findAllMovies(){
        return jdbcTemplate.query("SELECT * FROM MOVIES",new Object[]{},
                (rs,index) -> buildMovie(rs));
    }

    private Movie buildMovie(ResultSet rs) throws SQLException {
        int id = rs.getInt("MOVIE_ID");
        String name = rs.getString("MOVIE_NAME");
        LocalDate releaseDate = rs.getDate("RELEASE_DATE").toLocalDate();
        return new Movie(id, name, releaseDate);
    }


    public Movie getMovie(Integer id) throws ObjectNotFoundException {
        List<Movie> movies = jdbcTemplate.query("SELECT * FROM MOVIES WHERE MOVIE_ID = ?", new Object[]{id},
                (rs, index) -> buildMovie(rs));
        if (movies.size() == 1)
                return movies.get(0);
        else
            throw new ObjectNotFoundException(StringFormatter.format("Movie with id %s, does not exists.",id).get());
    }
}
