package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("repositoryTeacher")
public interface TeacherRepository extends PersonRepository{

    @Query("select t from Teacher t left join t.careers c where c.name = ?1")
    Iterable<Person> findTeachersByCareer(String career);

    @Query("select s from Teacher s")
    Iterable<Person> findAll();
}
