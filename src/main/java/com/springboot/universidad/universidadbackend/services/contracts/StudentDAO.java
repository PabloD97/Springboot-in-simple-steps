package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Person;

public interface StudentDAO extends PersonDAO{

    Iterable<Person> searchByNameCareer(String name);

}
