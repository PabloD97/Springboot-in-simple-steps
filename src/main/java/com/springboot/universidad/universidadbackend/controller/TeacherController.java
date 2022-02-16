package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.exception.BadRequestException;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import com.springboot.universidad.universidadbackend.services.contracts.TeacherDAO;
import com.springboot.universidad.universidadbackend.services.implementations.TeacherDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends PersonController{

    @Autowired
    public TeacherController(@Qualifier("teacherDAOImpl") PersonDAO service) {
        super(service);
        nameEntity = "Teacher";
    }


    @GetMapping("/teachersByCareer/{careerName}")
    public ResponseEntity<?> findTeachersByCareer(@PathVariable String careerName) {
        List<Person> listTeacher = (List<Person>) ((TeacherDAOImpl)service).findTeachersByCareer(careerName);
        if(listTeacher.isEmpty()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("There are no teachers with that career name: %n", careerName)
                    ));
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                listTeacher
        ));
    }

    @PutMapping("/addCareer/{idTeacher}/career/{idCareer}")
    public ResponseEntity<?> addCareerToTeacher(@PathVariable Integer idCareer, @PathVariable Integer idTeacher){
        Optional<Person> byId = service.findById(idTeacher);
        if(!byId.isPresent()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("The teacher with id: %i does not exist", idTeacher)
                    )
            );
        }

        String s = ((TeacherDAOImpl) service).addCareerToTeacher(idTeacher, idCareer);
        return ResponseEntity.ok(getMessage(Boolean.TRUE, "data",s));
    }

    private HashMap<String, Object> getMessage(Boolean bolean, String msj, Object o){
        HashMap<String, Object> message = new HashMap<>();
        message.put("success", bolean);
        message.put(msj, o);
        return message;
    }
}
