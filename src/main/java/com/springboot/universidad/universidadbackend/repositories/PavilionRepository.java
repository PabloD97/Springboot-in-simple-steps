package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Pavilion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PavilionRepository extends CrudRepository<Pavilion, Integer> {

    Iterable<Pavilion> findPavilionsByDirection_Location(String locationPavilion);
    Iterable<Pavilion> findPavilionsByName(String namePavilion);
}
