package com.sunitparekh.movierental.repository;

import com.sunitparekh.movierental.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    // Hibernate Query Language
    @Query("SELECT m FROM Movie m WHERE m.name like %:title%")
    List<Movie> findByTitleLike(@Param("title") String title);

    // Native Query
    @Query(value = "SELECT * FROM MOVIES WHERE YEAR(RELEASE_DATE) = ?1", nativeQuery = true)
    List<Movie> findByReleaseYear(Integer releaseYear);

}
