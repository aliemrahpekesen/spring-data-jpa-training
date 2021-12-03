package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Books")
public class Book extends MainEntity{

    public Book() {
    }

    public Book(String isbn, String author,String name) {
        super(name,"Test Datası");
        this.isbn = isbn;
        this.author = author;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
    @SequenceGenerator(name = "book_seq",sequenceName = "book_sequence")
    private Long id;

    private String isbn;
    private String author;

}
