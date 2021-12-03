package com.aep.training.aspect;

import com.aep.training.domain.exception.ResourceNotFoundException;
import com.aep.training.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFound(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest){
        ErrorResponse errorResponse = new ErrorResponse(new Date(),
                resourceNotFoundException.getMessage(),"error.code.rnfe",
                resourceNotFoundException.getStackTrace().toString());
        ResponseEntity response = new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        return response;
    }
}
