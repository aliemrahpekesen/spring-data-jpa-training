package com.aep.training.service.impl;

import com.aep.training.domain.entity.Book;
import com.aep.training.domain.entity.OpLog;
import com.aep.training.domain.entity.Student;
import com.aep.training.repository.OpLogRepository;
import com.aep.training.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LogServiceImpl implements LogService {

    private OpLogRepository opLogRepository;

    public LogServiceImpl(OpLogRepository opLogRepository) {
        this.opLogRepository = opLogRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createLog(Book book, Student student) {
        OpLog opLog = new OpLog();
        opLog.setOperation("CREATE_OR_UPDATE-STUDENT_WITH_BOOK");
        opLog.setLogMessage("Student and Book Created! Book Name : " + book.getName() + ", Student Name : " + student.getName());

        this.opLogRepository.save(opLog);
    }
}
