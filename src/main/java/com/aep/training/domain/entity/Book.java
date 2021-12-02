package com.aep.training.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String isbn;
    private String name;
    private String author;

    @OneToOne(mappedBy = "book")
    @JsonBackReference
    @ToString.Exclude
    private Student student;
}
