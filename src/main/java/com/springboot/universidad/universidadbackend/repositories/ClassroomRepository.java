package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Classroom;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.Blackboard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassroomRepository extends CrudRepository<Classroom, Integer> {

    /** Query Method **/
    Iterable<Classroom> findClassroomsByBlackboard(Blackboard blackboard);
    Iterable<Classroom> findClassroomsByPavilion_Name(String name);
    Optional<Classroom> findClassroomByNumberClassroom(Integer numberClassroom);
}
