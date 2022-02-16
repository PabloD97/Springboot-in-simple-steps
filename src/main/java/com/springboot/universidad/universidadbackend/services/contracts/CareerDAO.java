package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Career;


public interface CareerDAO extends GenericDAO<Career> {

    /**Nos permite encapsular el famoso Null Pointer Exception
     * y saber si hay presencia de datos el Optional
     */
    Iterable<Career> findCareersByNameContains(String name);
    Iterable<Career> findCareersByNameContainsIgnoreCase(String name);
    Iterable<Career> findCareersByAmountOfYearsAfter(Integer amountYears);
    Iterable<Career> findCareersByTeachersNameAndLastname(String name, String lastname);

}
