package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Classroom;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.Blackboard;
import com.springboot.universidad.universidadbackend.repositories.ClassroomRepository;
import com.springboot.universidad.universidadbackend.services.contracts.ClassroomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClassroomDAOImpl extends GenericDAOImpl<Classroom, ClassroomRepository> implements ClassroomDAO {

    @Autowired
    public ClassroomDAOImpl(ClassroomRepository repository) {
        super(repository);
    }


    @Override
    public Iterable<Classroom> findClassroomsByBlackboard(Blackboard blackboard) {
        return repository.findClassroomsByBlackboard(blackboard);
    }

    @Override
    public Iterable<Classroom> findClassroomsByPavilion_Name(String namePavilion) {
        return repository.findClassroomsByPavilion_Name(namePavilion);
    }

    @Override
    public Optional<Classroom> findClassroomByNumberClassroom(Integer numberClassroom) {
        return repository.findClassroomByNumberClassroom(numberClassroom);
    }
}
