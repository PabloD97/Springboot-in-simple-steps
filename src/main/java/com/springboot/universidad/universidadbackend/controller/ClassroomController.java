package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.model.entities.Classroom;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.Blackboard;
import com.springboot.universidad.universidadbackend.services.contracts.ClassroomDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/classrooms")
public class ClassroomController extends GenericController<Classroom, ClassroomDAO>{

    @Autowired
    public ClassroomController(ClassroomDAO service) {
        super(service);
        nameEntity = "Classroom";
    }

    @GetMapping("/findByBlackboard/{blackboard}")
    public ResponseEntity<?> getClassroomsByBlackboard(@PathVariable Blackboard blackboard){
        List<Classroom> classroomsByClassrooms = (List<Classroom>) service.findClassroomsByBlackboard(blackboard);
        if(classroomsByClassrooms.isEmpty()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE, "message",
                            String.format("There are no classrooms with that type of blackboard: %t", blackboard))
            );
        }

        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                classroomsByClassrooms
        ));

    }

    @GetMapping("/findByPavilionName/{pavilionName}")
    public ResponseEntity getClassroomsByPavilionName(@PathVariable String pavilionName){
        List<Classroom> classroomsByPavilionName = (List<Classroom>) service.findClassroomsByPavilion_Name(pavilionName);
        if(classroomsByPavilionName.isEmpty()){
            return ResponseEntity.badRequest()
                    .body(
                            getMessage(
                                    Boolean.FALSE, "message",
                                    String.format("There are no classrooms in the pavilion: %p",pavilionName)));
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                classroomsByPavilionName
        ));
    }

    @GetMapping("/findByNroAula/{nroClassroom}")
    public ResponseEntity<?> getClassroomByNroClassroom(@PathVariable Integer nroClassroom){
        Optional<Classroom> classroom = service.findClassroomByNumberClassroom(nroClassroom);
        if(!classroom.isPresent()){
            return ResponseEntity
                    .badRequest()
                    .body(getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("There is no classroom with the number: %n", nroClassroom)
                    ));
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                classroom.get()
        ));
    }


    private HashMap<String, Object> getMessage(Boolean bolean, String msj, Object o){
        HashMap<String, Object> message = new HashMap<>();
        message.put("success", bolean);
        message.put(msj, o);
        return message;
    }
}
