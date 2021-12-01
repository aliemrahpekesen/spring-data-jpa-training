package com.aep.training.controller.v1;

import com.aep.training.domain.entity.Student;
import com.aep.training.service.StudentService;
import com.aep.training.util.ApiConstant;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConstant.ROOT+"/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student) throws Exception {
        Student createdStudent = this.studentService.createOrUpdate(student);
        return createdStudent;
    }

    @GetMapping
    public List<Student> getAll(){
        List<Student> students = this.studentService.getAll();
        return students;
    }

    @GetMapping("/{studentId}")
    public Student getById(@PathVariable("studentId") Long studentId) throws Exception {
        Student foundStudent = this.studentService.getById(studentId);
        return foundStudent;
    }
/*
    @GetMapping("/{studentId}?operation=")
    public boolean isExist(@PathVariable("studentId") Long studentId,String operation) throws Exception {
       if("ec".equals(operation))
         return this.studentService.isExist(studentId);

       return false;
    }
    */

    @PutMapping
    public Student update(@RequestBody Student student) throws Exception {
        Student updatedStudent = this.studentService.createOrUpdate(student);
        return updatedStudent;
    }

    @DeleteMapping("/{studentId}")
    public void deleteById(@PathVariable("studentId") Long studentId) throws Exception {
       this.studentService.deleteById(studentId);
    }
}
