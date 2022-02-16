package com.springboot.universidad.universidadbackend.commands;

import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.entities.Direction;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Student;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import com.springboot.universidad.universidadbackend.services.contracts.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentCommands implements CommandLineRunner {

    @Autowired
    @Qualifier("studentDAOImpl")
    private PersonDAO personDAO;

    @Autowired
    private CareerDAO careerDAO;


    @Override
    public void run(String... args) throws Exception {
        /*
        Direction direction = new Direction("calle 554", "712", "1888", "Sucio", "14", "FV");

        Person pepe = new Student(null, "pepe", "diaz", "40651211", direction);
        Person martin = new Student(null, "martin", "diaz", "40651210", direction);

        personDAO.save(pepe);
        personDAO.save(martin);

        Optional<Career> career1 = careerDAO.findById(2);

        Iterable<Person> students = personDAO.findAll();
        students.forEach(student -> ((Student)student).setCareer(career1.get()));
        students.forEach(student -> personDAO.save(student));

        Optional<Person> student_1 = personDAO.findById(2);

        Optional<Person> personForNameAndLastname =
                personDAO.findByNameAndLastname(student_1.get().getName(), student_1.get().getLastname());
        System.out.println(personForNameAndLastname.get().toString());

        Optional<Person> personForDni =
                personDAO.findByDni("40651209");
        System.out.println(personForDni.get().toString());

        Iterable<Person> persons =
                personDAO.findByLastname("diaz");
        persons.forEach(System.out::println);

        Optional<Career> career1 = careerDAO.findById(2);

        Iterable<Person> students = ((StudentDAO)personDAO).searchByNameCareer(career1.get().getName());
        students.forEach(System.out::println);

         */

    }
}