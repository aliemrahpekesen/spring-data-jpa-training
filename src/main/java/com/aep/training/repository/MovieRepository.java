package com.aep.training.repository;

import com.aep.training.domain.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie,Long> {
}
