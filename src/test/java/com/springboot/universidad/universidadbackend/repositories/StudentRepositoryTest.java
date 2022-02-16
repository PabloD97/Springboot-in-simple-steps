package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.data.DataDummy;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    @Qualifier("repositoryStudent")
    private PersonRepository studentRepository;


    @Autowired
    private CareerRepository careerRepository;

    @Test
    void searchByNameCareer() {
        Iterable<Person> students = studentRepository.saveAll(
                Arrays.asList(
                        DataDummy.student01(),
                        DataDummy.student02(),
                        DataDummy.student03()
                )
        );

        Career career = careerRepository.save(DataDummy.carrera01(false));

        students.forEach(student -> ((Student)student).setCareer(career));

        studentRepository.saveAll(students);

        List<Person> personList = (List<Person>) ((StudentRepository)studentRepository).searchByNameCareer("Ingenieria en Sistemas");

        assertThat(personList.size() == 3).isTrue();

    }

    @Test
    void searchByNameCareerEmpty() {
        Iterable<Person> students = studentRepository.saveAll(
                Arrays.asList(
                        DataDummy.student01(),
                        DataDummy.student02(),
                        DataDummy.student03()
                )
        );

        Career career = careerRepository.save(DataDummy.carrera01(false));

        students.forEach(student -> ((Student)student).setCareer(career));

        studentRepository.saveAll(students);

        List<Person> personList = (List<Person>) ((StudentRepository)studentRepository).searchByNameCareer("Ingenieria en Alimentos");

        assertThat(personList.isEmpty()).isTrue();

    }
}