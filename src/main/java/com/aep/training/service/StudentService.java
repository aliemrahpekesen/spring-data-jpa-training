package com.aep.training.service;

import com.aep.training.domain.entity.Student;

import java.util.List;

public interface StudentService {
    Student createOrUpdate(Student student) throws Exception;

    List<Student> getAll();

    Student getById(Long studentId) throws Exception;

    void deleteById(Long studentId) throws Exception;

    boolean isExist(Long studentId);

    long getCount();

    Student getByName(String queryData);

    List<Student> getAllBySurname(String queryData);

    List<Student> getByNameAndSurname(String name,String surname);

    List<Student> getByNameOrSurname(String name,String surname);
}
