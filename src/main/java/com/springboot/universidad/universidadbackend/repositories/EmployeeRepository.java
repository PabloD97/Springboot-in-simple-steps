package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositoryEmployee")
public interface EmployeeRepository extends PersonRepository{

    @Query("select e from Employee e where e.typeEmployee = ?1")
    Iterable<Person> findEmployeesByTypeEmployee(TypeEmployee typeEmployee);


    @Query("select s from Employee s")
    Iterable<Person> findAll();
}
