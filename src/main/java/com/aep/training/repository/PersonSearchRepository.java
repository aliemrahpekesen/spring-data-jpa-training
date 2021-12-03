package com.aep.training.repository;

import com.aep.training.domain.entity.Person;
import com.aep.training.domain.model.PersonPage;
import com.aep.training.domain.model.PersonSearchCriteria;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class PersonSearchRepository {

    private final EntityManager entityManager;
    private final CriteriaBuilder criteriaBuilder;

    public PersonSearchRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Page<Person> searchByParameters(PersonPage personPage, PersonSearchCriteria personSearchCriteria){
        CriteriaQuery<Person> criteriaQuery = this.criteriaBuilder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        Predicate predicates = preparePredicates(personSearchCriteria,personRoot);
        criteriaQuery.where(predicates);
        prepareSortDirection(personPage,criteriaQuery,personRoot);

        TypedQuery<Person> personQuery = this.entityManager.createQuery(criteriaQuery);
        personQuery.setFirstResult(personPage.getPageNumber() * personPage.getPageSize());
        personQuery.setMaxResults(personPage.getPageSize());
        Pageable pageable = preparePageResult(personPage);

        long personResultCount = getCountOfSearchResults(predicates);

        return new PageImpl<>(personQuery.getResultList(),pageable,personResultCount);
    }

    private long getCountOfSearchResults(Predicate predicates) {
        CriteriaQuery<Long> countQuery = this.criteriaBuilder.createQuery(Long.class);
        Root<Person> personRoot = countQuery.from(Person.class);
        countQuery.select(this.criteriaBuilder.count(personRoot)).where(predicates);
        Long count = this.entityManager.createQuery(countQuery).getSingleResult();
        return count;
    }

    private Pageable preparePageResult(PersonPage personPage) {
        Sort sort = Sort.by(personPage.getSortDirection(),personPage.getSortBy());
        Pageable pageable = PageRequest.of(personPage.getPageNumber(),personPage.getPageSize(),sort);
        return pageable;
    }

    private void prepareSortDirection(PersonPage personPage, CriteriaQuery<Person> criteriaQuery, Root<Person> personRoot) {
        if(personPage.getSortDirection().equals(Sort.Direction.ASC))
            criteriaQuery.orderBy(this.criteriaBuilder.asc(personRoot.get(personPage.getSortBy())));
        else
            criteriaQuery.orderBy(this.criteriaBuilder.desc(personRoot.get(personPage.getSortBy())));
    }


    private Predicate preparePredicates(PersonSearchCriteria personSearchCriteria, Root<Person> personRoot) {
        List<Predicate> predicates = new ArrayList<>();

        if(Objects.nonNull(personSearchCriteria.getFirstName())){
            Predicate firstNamePredicate = this.criteriaBuilder.like(personRoot.get("firstName"),"%"+personSearchCriteria.getFirstName()+"%");
            predicates.add(firstNamePredicate);
        }

        if(Objects.nonNull(personSearchCriteria.getLastName())){
            Predicate lastNamePredicate = this.criteriaBuilder.like(personRoot.get("lastName"),"%"+personSearchCriteria.getLastName()+"%");
            predicates.add(lastNamePredicate);
        }

        Predicate[] predicatesArray = predicates.toArray(new Predicate[0]);
        return this.criteriaBuilder.and(predicatesArray);
    }

}
