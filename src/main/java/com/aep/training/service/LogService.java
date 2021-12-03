package com.aep.training.service;

import com.aep.training.domain.entity.Book;
import com.aep.training.domain.entity.Student;

public interface LogService {
    void createLog(Book book, Student student);
}
