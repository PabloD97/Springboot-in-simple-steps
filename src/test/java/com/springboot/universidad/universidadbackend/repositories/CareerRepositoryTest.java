package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.commands.CareerCommands;
import com.springboot.universidad.universidadbackend.data.DataDummy;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Teacher;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest//para que nuestros repositorios puedan ser inyectados y probarlos
class CareerRepositoryTest {

    @Autowired
    private CareerRepository careerRepository;


    @Autowired
    private TeacherRepository teacherRepository;

    @BeforeEach//antes de cada test
    void setup(){
        careerRepository.save(DataDummy.carrera01(false));
        careerRepository.save(DataDummy.carrera02());
        careerRepository.save(DataDummy.carrera03(false));
        teacherRepository.save(DataDummy.teacher01());
    }

    @AfterEach// despues de cada test
    void tearDown(){
        careerRepository.deleteAll();
    }

    @Test
    @DisplayName("Find Careers by name")
    void findCareersByNameContains() {
        //given/contexto


        //when/precondition
        Iterable<Career> expected = careerRepository.findCareersByNameContains("Sistemas");

        //then
        assertThat(((List<Career>)expected).size() == 2).isTrue();

    }

    @Test
    @DisplayName("Find Careers by name No case sensitive ")
    void findCareersByNameContainsIgnoreCase() {
        //given/contexto


        //when/precondition
        List<Career> expected = (List<Career>)careerRepository.findCareersByNameContainsIgnoreCase("sistemas");

        //then
        assertThat(expected.size() == 2).isTrue();

    }

    @Test
    @DisplayName("Find Careers by greater than N years")
    void findCareersByAmountOfYearsAfter() {
        //given/contexto

        //when/precondition
        List<Career> expected = (List<Career>)careerRepository.findCareersByAmountOfYearsAfter(4);

        //then
        assertThat(expected.size() == 2).isTrue();

    }

    @Test
    @DisplayName("Find Careers by techear name and lastname")
    void findCareersByTeachersNameAndLastname() {
        //given
        Optional<Career> career1 = careerRepository.findById(1);
        Optional<Career> career2 = careerRepository.findById(2);
        Optional<Person> teacher1Find = teacherRepository.findById(1);

        Set<Career> careers = new HashSet<>();
        careers.add(career1.get());
        careers.add(career2.get());
        ((Teacher) teacher1Find.get()).setCareers(careers);

        Set<Teacher> teachers = new HashSet<>();
        teachers.add((Teacher) teacher1Find.get());
        career1.get().setTeachers(teachers);
        career2.get().setTeachers(teachers);

        careerRepository.save(career1.get());
        careerRepository.save(career2.get());
        teacherRepository.save(teacher1Find.get());

        //when
        List<Career> careerOfTechear = (List<Career>) careerRepository.findCareersByTeachersNameAndLastname("Teacher1", "NN");

        //then
        assertThat(careerOfTechear.size() == 2).isTrue();

    }
}