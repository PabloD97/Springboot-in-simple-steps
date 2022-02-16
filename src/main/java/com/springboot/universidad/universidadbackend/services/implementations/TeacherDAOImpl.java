package com.springboot.universidad.universidadbackend.services.implementations;

import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Teacher;
import com.springboot.universidad.universidadbackend.repositories.CareerRepository;
import com.springboot.universidad.universidadbackend.repositories.PersonRepository;
import com.springboot.universidad.universidadbackend.repositories.TeacherRepository;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import com.springboot.universidad.universidadbackend.services.contracts.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TeacherDAOImpl extends PersonDAOImpl implements TeacherDAO {

    @Autowired
    private CareerDAO careerDAO;

    @Autowired
    public TeacherDAOImpl(@Qualifier("repositoryTeacher") PersonRepository repository) {
        super(repository);

    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Person> findTeachersByCareer(String career) {
        return ((TeacherRepository)repository).findTeachersByCareer(career);
    }

    @Transactional
    public String addCareerToTeacher(Integer idTeacher, Integer idCareer){
        Optional<Person> teacherById = repository.findById(idTeacher);
        Optional<Career> careerById = careerDAO.findById(idCareer);
        ((Teacher)teacherById.get()).addCareer(careerById.get());
        repository.save(teacherById.get());
        return "Se agrego la carrera";
    }

}
