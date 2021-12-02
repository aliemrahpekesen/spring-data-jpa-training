package com.aep.training.service;

import com.aep.training.domain.entity.Book;
import com.aep.training.domain.entity.Student;

import java.util.List;

public interface LogService {

    void createLog(Book book, Student student);
    void createLog(List<Book> bookList, Student student);

}
