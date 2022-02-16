package com.springboot.universidad.universidadbackend.commands;

import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component //para que esta clase sea inyectada con un Bean y poder utilizarla desde spring
public class CareerCommands implements CommandLineRunner {

    @Autowired
    private CareerDAO service;

    @Override
    public void run(String... args) throws Exception {
       /*Career tecnicaturaProgramacion = new Career(null, "Tecnicatura en Programación", 30, 4);
       Career tecnicaturaSociales = new Career(null, "Tecnicatura en Sociales", 20, 2);
       Career tecnicaturaMedica = new Career(null, "Tecnicatura Medica", 40, 5);
       Career tecnicaturaMatematica = new Career(null, "Tecnicatura en Matematica", 35, 4);

       service.save(tecnicaturaProgramacion);
       service.save(tecnicaturaSociales);
       service.save(tecnicaturaMedica);
       service.save(tecnicaturaMatematica);
        */

        //List<Career> careerList = (List<Career>)service.findCareersByNameContains("Sociales");
        //careerList.forEach(System.out::println);


        //List<Career> careerList1 = (List<Career>)service.findCareersByNameContainsIgnoreCase("sociales");
        //careerList1.forEach(System.out::println);


        //List<Career> careerList2 = (List<Career>)service.findCareersByAmountOfYearsAfter(2);
        //careerList2.forEach(System.out::println);

      //  Iterable<Career> careersTheTeacherWithNameAndLastname =
        //        service.findCareersByTeachersNameAndLastname("Teacher2", "nn");
        //careersTheTeacherWithNameAndLastname.forEach(System.out::println);
    }
}
