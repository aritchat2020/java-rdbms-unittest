package com.sunitparekh.movierental.repository;

import com.sunitparekh.movierental.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    Movie findById(Long id);

}
