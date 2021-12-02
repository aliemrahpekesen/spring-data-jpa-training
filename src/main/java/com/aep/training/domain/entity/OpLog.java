package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "OpLogs")
public class OpLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String operation;
    private String logMessage;
}
