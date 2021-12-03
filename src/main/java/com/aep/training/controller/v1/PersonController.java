package com.aep.training.controller.v1;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.model.PersonPage;
import com.aep.training.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // localhost:8080/people?sortDirection=ASC&sortBy=gender&pageSize=3&pageNumber=0
    @GetMapping
    public ResponseEntity<Page<Person>> getAll(PersonPage personPage){
        Page<Person> people = this.personService.getAll(personPage);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
