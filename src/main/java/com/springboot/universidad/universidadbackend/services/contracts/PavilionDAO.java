package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Pavilion;

public interface PavilionDAO extends GenericDAO<Pavilion>{

    Iterable<Pavilion> findPavilionsByDirection_Location(String locationPavilion);
    Iterable<Pavilion> findPavilionsByName(String namePavilion);
}
