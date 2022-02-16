package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.repositories.PersonRepository;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonDAOImpl extends GenericDAOImpl<Person, PersonRepository> implements PersonDAO {

    @Autowired
    public PersonDAOImpl(PersonRepository repository) {
        super(repository);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByNameAndLastname(String name, String lastname) {
        return repository.findByNameAndLastname(name, lastname);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findByLastname(String lastname) {
        return repository.findByLastname(lastname);
    }


}
