package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.repositories.CareerRepository;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CareerDAOImpl extends GenericDAOImpl<Career, CareerRepository> implements CareerDAO {

    @Autowired
    public CareerDAOImpl(CareerRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNameContains(String name) {
        return repository.findCareersByNameContains(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByNameContainsIgnoreCase(String name) {
        return repository.findCareersByNameContainsIgnoreCase(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByAmountOfYearsAfter(Integer amountYears) {
        return repository.findCareersByAmountOfYearsAfter(amountYears);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Career> findCareersByTeachersNameAndLastname(String name, String lastname) {
        return repository.findCareersByTeachersNameAndLastname(name, lastname);
    }
}
