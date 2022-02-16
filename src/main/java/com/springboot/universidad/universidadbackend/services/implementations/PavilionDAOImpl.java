package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Classroom;
import com.springboot.universidad.universidadbackend.model.entities.Pavilion;
import com.springboot.universidad.universidadbackend.repositories.ClassroomRepository;
import com.springboot.universidad.universidadbackend.repositories.PavilionRepository;
import com.springboot.universidad.universidadbackend.services.contracts.ClassroomDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PavilionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PavilionDAOImpl  extends GenericDAOImpl<Pavilion, PavilionRepository> implements PavilionDAO {

    @Autowired
    public PavilionDAOImpl(PavilionRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Pavilion> findPavilionsByDirection_Location(String locationPavilion) {
        return repository.findPavilionsByDirection_Location(locationPavilion);
    }

    @Override
    public Iterable<Pavilion> findPavilionsByName(String namePavilion) {
        return repository.findPavilionsByName(namePavilion);
    }
}
