package com.aep.training.service;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.exception.ResourceNotFoundException;
import com.aep.training.domain.model.PersonPage;
import com.aep.training.domain.model.PersonSearchCriteria;
import org.springframework.data.domain.Page;


public interface PersonService {

    Person getById(Long personId);
    Page<Person> getAll(PersonPage personPage);
    Page<Person> search(PersonPage personPage, PersonSearchCriteria personSearchCriteria) throws ResourceNotFoundException;
}
