package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Person;

import java.util.Optional;

public interface PersonDAO extends GenericDAO<Person>{


    Optional<Person> findByNameAndLastname(String name, String lastname);
    Optional<Person> findByDni(String dni);
    Iterable<Person> findByLastname(String lastname);
}
