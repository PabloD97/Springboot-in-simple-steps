package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Career;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** Esto no es necesario, ya que al extender de CrudRepository Spring sabe que es un
 * repository, pero es una buena practica colocar la annotation
 **/
@Repository
public interface CareerRepository extends CrudRepository<Career, Integer> {

    /** Documentacion de jpa
     *  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation**/
    /** Query a traves de metodo **/
    //@Query("select c from Career c where c.name like %?1%")
    Iterable<Career> findCareersByNameContains(String name);

    //@Query("select c from Career c where upper(c.name) like upper(%?1%)")
    Iterable<Career> findCareersByNameContainsIgnoreCase(String name);

    /** After quiere decir > a ese valor**/
    //@Query("select c from Career c where c.amountOfYears > ?1")
    Iterable<Career> findCareersByAmountOfYearsAfter(Integer amountYears);

    @Query("select c from Career c join fetch c.teachers t where t.name = ?1 and t.lastname = ?2")
    Iterable<Career> findCareersByTeachersNameAndLastname(String name, String lastname);

}
