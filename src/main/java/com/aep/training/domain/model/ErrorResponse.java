package com.aep.training.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private Date timeStamp;
    private String message;
    private String code;
    private String details;
}
