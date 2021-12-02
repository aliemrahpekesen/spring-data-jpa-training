package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq",sequenceName = "book_sequence")
    private Long id;

    private String isbn;
    private String name;
    private String author;

}
