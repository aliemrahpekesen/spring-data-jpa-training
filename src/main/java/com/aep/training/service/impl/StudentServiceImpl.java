package com.aep.training.service.impl;

import com.aep.training.domain.entity.Student;
import com.aep.training.repository.StudentRepository;
import com.aep.training.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Override
    public Student createOrUpdate(Student student) throws Exception {
        if(student.getId()!=null && student.getId()>0){
            if(this.studentRepository.findById(student.getId()).isPresent()) {
                this.studentRepository.save(student);
                return student;
            }
            else
                throw new Exception("Resource Not Found");
        }
        Student createdStudent = this.studentRepository.save(student);
        return createdStudent;
    }

    @Override
    public List<Student> getAll() {
        Iterable<Student> students = this.studentRepository.findAll();
        return (List<Student>) students;
    }

    @Override
    public Student getById(Long studentId) throws Exception {
        Optional<Student> foundStudent = this.studentRepository.findById(studentId);
        if(foundStudent.isPresent())
            return foundStudent.get();
        else
            throw new Exception("Resource Not Found");
    }

    @Override
    public void deleteById(Long studentId) throws Exception {
        Optional<Student> foundStudent = this.studentRepository.findById(studentId);
        if(foundStudent.isPresent())
            this.studentRepository.deleteById(studentId);
        else
            throw new Exception("Resource Not Found");

    }

    @Override
    public boolean isExist(Long studentId) {
        return this.studentRepository.existsById(studentId);
    }
}
