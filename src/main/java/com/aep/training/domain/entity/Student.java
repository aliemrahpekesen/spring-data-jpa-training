package com.aep.training.domain.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Students")
public class Student extends MainEntity{

    public Student() {
    }

    public Student(String name, String surname, Book book) {
        super(name,"Test Datası");
        this.surname = surname;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @SequenceGenerator(name = "student_seq",sequenceName = "student_sequence")
    private Long id;

    @Column(nullable = false)
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;
}
