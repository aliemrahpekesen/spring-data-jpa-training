package com.aep.training.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    @JsonManagedReference
    private Book book;
}
