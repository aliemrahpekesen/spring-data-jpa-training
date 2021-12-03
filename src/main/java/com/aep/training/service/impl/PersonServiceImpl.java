package com.aep.training.service.impl;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.model.PersonPage;
import com.aep.training.domain.model.PersonSearchCriteria;
import com.aep.training.domain.exception.ResourceNotFoundException;
import com.aep.training.repository.PersonRepository;
import com.aep.training.repository.PersonSearchRepository;
import com.aep.training.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final PersonSearchRepository personSearchRepository;

    public PersonServiceImpl(PersonRepository personRepository, PersonSearchRepository personSearchRepository) {
        this.personRepository = personRepository;
        this.personSearchRepository = personSearchRepository;
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

    @Override
    public Page<Person> search(PersonPage personPage, PersonSearchCriteria personSearchCriteria) throws ResourceNotFoundException {
        Page<Person> searchResults = this.personSearchRepository.searchByParameters(personPage, personSearchCriteria);
        if(searchResults.getTotalElements()==0)
            throw new ResourceNotFoundException("Hiç Sonuç Gelmedi!");
        return this.personSearchRepository.searchByParameters(personPage,personSearchCriteria);
    }
}
