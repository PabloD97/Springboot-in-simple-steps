package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.exception.BadRequestException;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.Student;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import com.springboot.universidad.universidadbackend.services.contracts.StudentDAO;
import com.springboot.universidad.universidadbackend.services.implementations.StudentDAOImpl;
import com.springboot.universidad.universidadbackend.services.implementations.TeacherDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController extends PersonController{

    private PersonDAO personDAO;
    private CareerDAO careerDAO;

    @Autowired
    public StudentController(@Qualifier("studentDAOImpl") PersonDAO personDAO, CareerDAO careerDAO) {
        super(personDAO);
        this.careerDAO = careerDAO;
        nameEntity = "Student";
    }



    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Person student){
        Map<String, Object> message = new HashMap<>();
        Optional<Person> oldStudent = personDAO.findById(id);
        Person studentR = null;
        if(!oldStudent.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("%s whit ID %d does not exist", nameEntity, id));
            return ResponseEntity.badRequest().body(message);
        }
        studentR = oldStudent.get();
        studentR.setDni(student.getDni());
        studentR.setName(student.getName());
        studentR.setLastname(student.getLastname());

        message.put("success", Boolean.TRUE);
        message.put("data", personDAO.save(studentR));
        return ResponseEntity.ok(message);
    }


    @PutMapping("/{idStudent}/career/{idCareer}")
    public ResponseEntity<?> addCareerToStudent(@PathVariable Integer idStudent, @PathVariable Integer idCareer){
        Map<String, Object> message = new HashMap<>();
        Optional<Person> optionalStudent = personDAO.findById(idStudent);
        if(!optionalStudent.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("Student whit ID %d does not exist", idStudent));
            return ResponseEntity.badRequest().body(message);
        }
        Optional<Career> optionalCareer = careerDAO.findById(idCareer);
        if(!optionalCareer.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("Career whit ID %d does not exist", idCareer));
            return ResponseEntity.badRequest().body(message);
        }

        Student student = (Student) optionalStudent.get();
        Career career = optionalCareer.get();
        student.setCareer(career);

        message.put("success", Boolean.TRUE);
        message.put("data", personDAO.save(student));
        return ResponseEntity.ok(message);    }


}
