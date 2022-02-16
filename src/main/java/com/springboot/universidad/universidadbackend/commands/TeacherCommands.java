package com.springboot.universidad.universidadbackend.commands;

import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.entities.Direction;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Teacher;
import com.springboot.universidad.universidadbackend.repositories.TeacherRepository;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import com.springboot.universidad.universidadbackend.services.contracts.TeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class TeacherCommands implements CommandLineRunner {

    @Autowired
    @Qualifier("teacherDAOImpl")
    private PersonDAO personDAO;

    @Autowired
    private CareerDAO careerDAO;

    @Override
    public void run(String... args) throws Exception {

        /*
        Direction direction = new Direction("calle 554", "712", "1888", "Sucio", "14", "FV");

        Person teacher1 = new Teacher(null, "Teacher1", "nn","123456",direction, new BigDecimal("34900"));
        Person teacher2 = new Teacher(null, "Teacher2", "nn","123457",direction, new BigDecimal("34911"));
        Person teacher3 = new Teacher(null, "Teacher3", "nn","123458",direction, new BigDecimal("34922"));


        personDAO.save(teacher1);
        personDAO.save(teacher2);
        personDAO.save(teacher3);


        Optional<Career> career1 = careerDAO.findById(1);
        Optional<Career> career2 = careerDAO.findById(2);
        Optional<Career> career3 = careerDAO.findById(3);

        Optional<Person> teacher1Find = personDAO.findById(4);
        Set<Career> careers = new HashSet<>();
        careers.add(career1.get());
        careers.add(career2.get());
        ((Teacher) teacher1Find.get()).setCareers(careers);

        Set<Teacher> teachers = new HashSet<>();
        teachers.add((Teacher) teacher1Find.get());
        career1.get().setTeachers(teachers);
        career2.get().setTeachers(teachers);



        //techear 2
        Optional<Career> career3 = careerDAO.findById(3);

        Optional<Person> teacher2Find = personDAO.findById(5);

        Set<Career> careers2 = new HashSet<>();
        careers2.add(career3.get());
        ((Teacher) teacher2Find.get()).setCareers(careers2);

        Set<Teacher> teachers2 = new HashSet<>();
        teachers2.add((Teacher) teacher2Find.get());
        career3.get().setTeachers(teachers2);


        //personDAO.save(teacher1Find.get());
        personDAO.save(teacher2Find.get());
        //careerDAO.save(career1.get());
        //careerDAO.save(career2.get());
        careerDAO.save(career3.get());


        //Iterable<Person> teachersFindByCareer = ((TeacherDAO)personDAO).findTeachersByCareer(career1.get().getName());
        //teachers.forEach(System.out::println);




         */

    }
}
