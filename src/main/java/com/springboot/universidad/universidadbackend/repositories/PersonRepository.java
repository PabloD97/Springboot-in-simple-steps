package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

// Para que no nos genere un Bean de este repository,
// pero si que nos genere los siguientes que son necesarios
// de nuestras clases hijas
@NoRepositoryBean
public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("select p from Person p where p.name = ?1 and p.lastname = ?2")
    Optional<Person> findByNameAndLastname(String name, String lastname);

    @Query("select p from Person p where p.dni = ?1")
    Optional<Person> findByDni(String dni);

    // "like" para que pegue con todo lo que tenga ese apellido
    @Query("select p from Person p where p.lastname like %?1%")
    Iterable<Person> findByLastname(String lastname);
}
