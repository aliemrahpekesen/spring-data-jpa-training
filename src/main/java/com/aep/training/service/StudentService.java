package com.aep.training.service;

import com.aep.training.domain.entity.Student;

public interface StudentService {
    Student createOrUpdate(Student student);
}
