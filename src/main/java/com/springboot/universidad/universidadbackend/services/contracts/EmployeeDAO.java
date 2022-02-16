package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;

public interface EmployeeDAO extends PersonDAO{

    Iterable<Person> findEmployeesByTypeEmployee(TypeEmployee typeEmployee);
    Person assignPavilion(Integer idEmployee, Integer idPavilion);

}
