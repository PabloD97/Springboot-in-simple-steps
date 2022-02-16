package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.services.contracts.GenericDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class GenericDAOImpl<E, R extends CrudRepository<E, Integer>> implements GenericDAO<E> {


    protected final R repository;

    public GenericDAOImpl(R repository) {
        this.repository = repository;
    }

    /** Como este servicio va a trabajar con transacciones con la DB
     * hay que decorarlo la annotation @Transactional que derive de Spring framework **/

    @Override
    @Transactional(readOnly = true)
    public Optional<E> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<E> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
