package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_sequence")
    private Long id;

    private String name;

    @Column(nullable = false)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
}
