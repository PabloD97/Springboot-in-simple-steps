package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Career;

import java.util.Optional;

//Generico para utilizarlo en los demas DAO
public interface GenericDAO<E> {

    Optional<E> findById(Integer id);
    E save(E e);
    Iterable<E> findAll();
    void deleteById(Integer id);
}
