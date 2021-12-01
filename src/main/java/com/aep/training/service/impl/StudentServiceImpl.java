package com.aep.training.service.impl;

import com.aep.training.domain.entity.Student;
import com.aep.training.repository.StudentRepository;
import com.aep.training.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Override
    public Student createOrUpdate(Student student) {
        Student createdStudent = this.studentRepository.save(student);
        return createdStudent;
    }
}
