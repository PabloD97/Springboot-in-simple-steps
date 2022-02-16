package com.springboot.universidad.universidadbackend.repositories;

import com.springboot.universidad.universidadbackend.data.DataDummy;
import com.springboot.universidad.universidadbackend.model.entities.Employee;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    @Qualifier("repositoryStudent")
    private PersonRepository studentRepository;


    @Autowired
    @Qualifier("repositoryEmployee")
    private PersonRepository employeeRepository;


    @Autowired
    @Qualifier("repositoryTeacher")
    private PersonRepository teacherRepository;

    @AfterEach
    void tearDown(){
        employeeRepository.deleteAll();
        teacherRepository.deleteAll();
        studentRepository.deleteAll();
    }

    @Test
    void findByNameAndLastname() {
        //Given
        employeeRepository.save(DataDummy.employee01());

        //when
        Optional<Person> employee01 = employeeRepository.findByNameAndLastname(DataDummy.employee01().getName(), DataDummy.employee01().getLastname());

        //then
        assertThat(employee01.get()).isInstanceOf(Employee.class);
    }

    @Test
    void findByDni() {
        //Given
        Person save = employeeRepository.save(DataDummy.employee01());

        //when
        Optional<Person> employee01 = employeeRepository.findByDni(DataDummy.employee01().getDni());

        //then
        assertThat(employee01.get()).isInstanceOf(Employee.class);
        assertThat(employee01.get()).isEqualTo(save);
    }

    @Test
    void findByLastname() {
        //Given
        employeeRepository.save(DataDummy.employee01());
        teacherRepository.save(DataDummy.teacher01());
        studentRepository.save(DataDummy.student01());

        //when
        List<Person> personList = (List<Person>) employeeRepository.findByLastname("NN");
        List<Person> personLastnameDiaz = (List<Person>) employeeRepository.findByLastname("Diaz");

        //then
        assertThat(personList.size() == 2).isTrue();
        assertThat(personLastnameDiaz.size() == 1).isTrue();
    }
}