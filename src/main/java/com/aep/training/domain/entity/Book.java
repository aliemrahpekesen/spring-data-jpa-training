package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String isbn;
    private String name;
    private String author;

    @OneToOne(mappedBy = "book")
    private Student student;
}
