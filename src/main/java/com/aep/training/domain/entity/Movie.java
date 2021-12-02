package com.aep.training.domain.entity;

import com.aep.training.domain.enums.MovieLanguage;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq",sequenceName = "movie_sequence")
    private Long id;

    @Column(name = "name",nullable = false,length = 100,unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private MovieLanguage movieLanguage;

    @ManyToMany(mappedBy = "castedMovies")

    @ToString.Exclude
    private List<Actor> movieActors = new ArrayList<>();

    public void addActor(Actor actor){
        this.movieActors.add(actor);
    }

}
