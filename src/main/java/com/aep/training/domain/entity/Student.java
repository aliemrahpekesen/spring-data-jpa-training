package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private String surname;
}
