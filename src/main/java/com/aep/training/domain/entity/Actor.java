package com.aep.training.domain.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Actors")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_seq")
    @SequenceGenerator(name = "movie_seq",sequenceName = "movie_sequence")
    private Long id;

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "movie_actors",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    @ToString.Exclude
    private List<Movie> castedMovies = new ArrayList<>();

    public void addMovie(Movie movie){
        this.castedMovies.add(movie);
    }

}
