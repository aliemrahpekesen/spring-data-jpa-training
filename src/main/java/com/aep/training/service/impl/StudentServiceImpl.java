package com.aep.training.service.impl;

import com.aep.training.domain.entity.Book;
import com.aep.training.domain.entity.Student;
import com.aep.training.repository.BookRepository;
import com.aep.training.repository.StudentRepository;
import com.aep.training.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    
    private StudentRepository studentRepository;
    private BookRepository bookRepository;

    public StudentServiceImpl(StudentRepository studentRepository,BookRepository bookRepository) {
        this.studentRepository = studentRepository;
        this.bookRepository = bookRepository;
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
            Book java= new Book();
            java.setIsbn("654321");
            java.setName("Java2");
            java.setAuthor("Uncle Bob");
            student.setBook(java);

        Student createdStudent =   this.studentRepository.save(student);
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

    @Override
    public long getCount() {
        return this.studentRepository.count();
    }

    @Override
    public Student getByName(String queryData) {
        return this.studentRepository.findByName(queryData);
    }

    @Override
    public List<Student> getAllBySurname(String queryData) {
        return this.studentRepository.findAllBySurname(queryData);
    }

    @Override
    public List<Student> getByNameAndSurname(String name, String surname) {
        return this.studentRepository.findByNameAndSurname(name,surname);
    }

    @Override
    public List<Student> getByNameOrSurname(String name, String surname) {
        return this.studentRepository.findByNameOrSurname(name,surname);
    }
}
