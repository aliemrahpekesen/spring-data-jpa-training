package com.aep.training.repository;

import com.aep.training.domain.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {

    Student findByName(String queryData);

    List<Student> findAllBySurname(String queryData);

    //byNameAndSurname
    //byNameOrSurname


}
