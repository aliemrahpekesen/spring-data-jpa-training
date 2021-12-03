package com.aep.training.controller.v1;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.exception.ResourceNotFoundException;
import com.aep.training.domain.model.PersonPage;
import com.aep.training.domain.model.PersonSearchCriteria;
import com.aep.training.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/people")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<Page<Person>> search(PersonPage personPage, PersonSearchCriteria personSearchCriteria) throws ResourceNotFoundException {
        Page<Person> searchResult = this.personService.search(personPage,personSearchCriteria);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }

}
