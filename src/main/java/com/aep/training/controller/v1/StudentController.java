package com.aep.training.controller.v1;

import com.aep.training.domain.entity.Student;
import com.aep.training.service.StudentService;
import com.aep.training.util.ApiConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConstant.ROOT+"/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        Student createdStudent = this.studentService.createOrUpdate(student);
        return createdStudent;
    }
}
