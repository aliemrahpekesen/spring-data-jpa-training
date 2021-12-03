package com.aep.training.domain.entity;

import com.aep.training.domain.enums.Gender;
import com.aep.training.domain.enums.Language;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "People")
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq",sequenceName = "person_sequence")
    private Long id;

    @Column(name = "firstName",nullable = false,length = 100)
    private String firstName;

    @Column(name = "lastName",nullable = false,length = 150)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Language language;

    public Person(String firstName, String lastName, Gender gender, Language language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.language = language;
    }
}
