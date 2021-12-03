package com.aep.training;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.enums.Gender;
import com.aep.training.domain.enums.Language;
import com.aep.training.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);


        List<Person> people = Arrays.asList(
                new Person("Ali Emrah", "PEKESEN", Gender.ERKEK, Language.TURKISH),
                new Person("Kıvanç", "PEKESEN", Gender.ERKEK, Language.TURKISH),
                new Person("Asiye", "PEKESEN", Gender.KADIN, Language.TURKISH),
                new Person("Yamaç", "PEKESEN", Gender.ERKEK, Language.ENGLISH),
                new Person("Hakan", "SAR", Gender.ERKEK, Language.TURKISH),
                new Person("Ayşe", "SAR", Gender.KADIN, Language.TURKISH)
        );

        PersonRepository personRepository = context.getBean(PersonRepository.class);
        personRepository.saveAll(people);

    }


}
