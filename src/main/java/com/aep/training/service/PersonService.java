package com.aep.training.service;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.model.PersonPage;
import org.springframework.data.domain.Page;


public interface PersonService {

    Person getById(Long personId);
    Page<Person> getAll(PersonPage personPage);
}
