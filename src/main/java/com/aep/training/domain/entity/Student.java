package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;

    @OneToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
}
