package com.aep.training;

import com.aep.training.domain.entity.Actor;
import com.aep.training.domain.entity.Movie;
import com.aep.training.domain.enums.MovieLanguage;
import com.aep.training.repository.ActorRepository;
import com.aep.training.repository.MovieRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


        MovieRepository movieRepository = context.getBean(MovieRepository.class);
        ActorRepository actorRepository = context.getBean(ActorRepository.class);

        Actor kemalSunal = new Actor();
        kemalSunal.setFirstName("Kemal");
        kemalSunal.setLastName("SUNAL");

        Actor metinAkpinar = new Actor();
        metinAkpinar.setFirstName("Metin");
        metinAkpinar.setLastName("AKPINAR");

        Actor rustuAsyali = new Actor();
        rustuAsyali.setFirstName("Rüştü");
        rustuAsyali.setLastName("ASYALI");

        Movie keloglan = new Movie();
        keloglan.setName("Keloğlan Aramızda");
        keloglan.setMovieLanguage(MovieLanguage.TUR);

        Movie koydenIndimSehire = new Movie();
        koydenIndimSehire.setName("Köyden İndim Şehire");
        koydenIndimSehire.setMovieLanguage(MovieLanguage.TUR);

        List<Movie> filmler = Arrays.asList(keloglan,koydenIndimSehire);
        movieRepository.saveAll(filmler);

        kemalSunal.addMovie(koydenIndimSehire);
        metinAkpinar.addMovie(koydenIndimSehire);
        rustuAsyali.addMovie(keloglan);
        rustuAsyali.addMovie(koydenIndimSehire);

        List<Actor> oyuncular = Arrays.asList(kemalSunal,metinAkpinar,rustuAsyali);

        actorRepository.saveAll(oyuncular);




    }

}
