package com.aep.training.repository;

import com.aep.training.domain.entity.OpLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpLogRepository extends CrudRepository<OpLog,Long> {
}
