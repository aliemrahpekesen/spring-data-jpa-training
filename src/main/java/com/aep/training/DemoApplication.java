package com.aep.training;

import com.aep.training.domain.entity.Book;
import com.aep.training.domain.entity.Student;
import com.aep.training.repository.BookRepository;
import com.aep.training.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @PostConstruct
    public void biDirectionalTestCode(){
        Book book = new Book();
        book.setIsbn("123456789");
        book.setAuthor("Ahmet");
        book.setName("Hello World!");

        Student student = new Student();
        student.setName("Emrah");
        student.setSurname("PEKESEN");
        student.setBook(book);

        StudentRepository studentRepository = context.getBean(StudentRepository.class);
        Long instertedStudentId = studentRepository.save(student).getId();

        System.out.println("Fetching Student from H2 Database...........");
        Optional<Student> foundStudentOptional = studentRepository.findById(instertedStudentId);
        if(foundStudentOptional.isPresent()){
            Student foundStudent = foundStudentOptional.get();
            System.out.println("Student Info : "+foundStudent);

            Long studentBookId = foundStudent.getBook().getId();
            BookRepository bookRepository = context.getBean(BookRepository.class);
            Optional<Book> foundBookOptional = bookRepository.findById(studentBookId);
            if(foundBookOptional.isPresent()){
                Book foundBook = foundBookOptional.get();
                System.out.println("Book Info : "+foundBook);
                System.out.println("Books owner : "+ foundBook.getStudent().getName() +" "+ foundBook.getStudent().getSurname());
            }
        }





    }


}
