package com.springboot.universidad.universidadbackend.services.contracts;

import com.springboot.universidad.universidadbackend.model.entities.Classroom;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.Blackboard;

import java.util.Optional;

public interface ClassroomDAO extends GenericDAO<Classroom>{

    Iterable<Classroom> findClassroomsByBlackboard(Blackboard blackboard);
    Iterable<Classroom> findClassroomsByPavilion_Name(String name);
    Optional<Classroom> findClassroomByNumberClassroom(Integer numberClassroom);

}
