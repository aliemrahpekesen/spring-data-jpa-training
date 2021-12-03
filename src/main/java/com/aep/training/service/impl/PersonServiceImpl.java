package com.aep.training.service.impl;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.model.PersonPage;
import com.aep.training.repository.PersonRepository;
import com.aep.training.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person getById(Long personId) {
        return this.personRepository.findById(personId).get();
    }

    @Override
    public Page<Person> getAll(PersonPage personPage) {
        Sort sort = Sort.by(personPage.getSortDirection(),personPage.getSortBy());
        Pageable pageable = PageRequest.of(personPage.getPageNumber(),personPage.getPageSize(),sort);
        return this.personRepository.findAll(pageable);
    }
}
