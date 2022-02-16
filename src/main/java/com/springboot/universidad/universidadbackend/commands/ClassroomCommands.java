package com.springboot.universidad.universidadbackend.commands;

import com.springboot.universidad.universidadbackend.model.entities.Classroom;
import com.springboot.universidad.universidadbackend.model.entities.Direction;
import com.springboot.universidad.universidadbackend.model.entities.Pavilion;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.Blackboard;
import com.springboot.universidad.universidadbackend.services.contracts.ClassroomDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PavilionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class ClassroomCommands implements CommandLineRunner {

    @Autowired
    private ClassroomDAO classroomDAO;

    @Autowired
    private PavilionDAO pavilionDAO;


    @Override
    public void run(String... args) throws Exception {
/*
        Classroom classroom1 = new Classroom(null, 1, "40x43", 20, Blackboard.BOAR_WHITE);
        Classroom classroom2 = new Classroom(null, 2, "40x42", 20, Blackboard.BOAR_WHITE);
        Classroom classroom3 = new Classroom(null, 3, "40x43", 20, Blackboard.BOAR_WHITEBOARD);

        classroomDAO.save(classroom1);
        classroomDAO.save(classroom2);
        classroomDAO.save(classroom3);

        //Iterable<Classroom> classroomsTypeBlackboardWhite = classroomDAO.findClassroomsByBlackboard(Blackboard.BOAR_WHITEBOARD);
        //classroomsTypeBlackboardWhite.forEach(System.out::println);


        Direction direction = new Direction("calle 554", "712", "1888", "Pavilion1", "14", "FV");
        Pavilion pavilion1 = new Pavilion(null, 4.0, "Pavilion1", direction);
        Pavilion pavilion2 = new Pavilion(null, 4.0, "Pavilion2", direction);

        pavilionDAO.save(pavilion1);
        pavilionDAO.save(pavilion2);



        //Agregar pavilion
        Iterable<Classroom> classroomIterable = classroomDAO.findAll();
        Set<Classroom> classrooms = new HashSet<>();
        classroomIterable.forEach(classroom -> {
            classrooms.add(classroom);
        });
        Optional<Pavilion> pavilionfind1 = pavilionDAO.findById(1);

        pavilionfind1.get().setClassrooms(classrooms);

        classrooms.forEach(classroom -> {
            classroom.setPavilion(pavilionfind1.get());
        });

        pavilionDAO.save(pavilionfind1.get());
        classrooms.forEach(classroom -> {
            classroomDAO.save(classroom);
        });

 */
        //Iterable<Classroom> classroomFindByNamePavilion2 = classroomDAO.findClassroomsByPavilion_Name("Pavilion2");
        //classroomFindByNamePavilion2.forEach(System.out::println);

        //Iterable<Classroom> classroomFindByNamePavilion1 = classroomDAO.findClassroomsByPavilion_Name("Pavilion1");
        //classroomFindByNamePavilion1.forEach(System.out::println);
        //System.out.println(classroomDAO.findClassroomByNumberClassroom(3).get().toString());
    }
}
