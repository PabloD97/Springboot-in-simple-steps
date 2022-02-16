package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// Cada vez que nosotros generemos un compoenent, service o repository.
// Se va crear un bean con ese nombre.
@Repository("repositoryStudent")
public interface StudentRepository extends PersonRepository{

    @Query("select s from Student s join fetch s.career c where c.name = ?1")
    Iterable<Person> searchByNameCareer(String name);

    @Query("select s from Student s")
    Iterable<Person> findAll();
}
