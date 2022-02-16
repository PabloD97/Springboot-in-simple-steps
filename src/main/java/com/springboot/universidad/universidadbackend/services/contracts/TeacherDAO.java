package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Person;

public interface TeacherDAO extends PersonDAO{

    Iterable<Person> findTeachersByCareer(String career);

}
