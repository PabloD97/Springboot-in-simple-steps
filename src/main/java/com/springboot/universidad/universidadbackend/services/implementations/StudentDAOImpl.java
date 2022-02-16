package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.repositories.PersonRepository;
import com.springboot.universidad.universidadbackend.repositories.StudentRepository;
import com.springboot.universidad.universidadbackend.services.contracts.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class StudentDAOImpl extends PersonDAOImpl implements StudentDAO {

    @Autowired
    public StudentDAOImpl(@Qualifier("repositoryStudent")PersonRepository repository) {
        super(repository);
    }

    @Override
    public Iterable<Person> searchByNameCareer(String name){
        return ((StudentRepository)repository).searchByNameCareer(name);
    };

}
