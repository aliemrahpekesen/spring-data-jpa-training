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
}
