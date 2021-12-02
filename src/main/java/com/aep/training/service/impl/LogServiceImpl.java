package com.aep.training.service.impl;

import com.aep.training.domain.entity.Book;
import com.aep.training.domain.entity.OpLog;
import com.aep.training.domain.entity.Student;
import com.aep.training.repository.OpLogRepository;
import com.aep.training.service.LogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void createLog(List<Book> bookList, Student student) {
        List<OpLog> allLogs = new ArrayList<>();
        for (Book book : bookList ) {
            OpLog opLog = new OpLog();
            opLog.setOperation("CREATE_OR_UPDATE-STUDENT_WITH_BOOK");
            opLog.setLogMessage("Student and Book Created! Book Name : " + book.getName() + ", Student Name : " + student.getName());
            allLogs.add(opLog);
        }
        this.opLogRepository.saveAll(allLogs);
    }
}
