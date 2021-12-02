package com.aep.training.repository;

import com.aep.training.domain.entity.Actor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends CrudRepository<Actor,Long> {
}
