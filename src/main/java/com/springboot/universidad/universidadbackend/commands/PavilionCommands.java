package com.springboot.universidad.universidadbackend.commands;

import com.springboot.universidad.universidadbackend.model.entities.Direction;
import com.springboot.universidad.universidadbackend.model.entities.Pavilion;
import com.springboot.universidad.universidadbackend.services.contracts.PavilionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PavilionCommands implements CommandLineRunner {

    @Autowired
    private PavilionDAO pavilionDAO;

    @Override
    public void run(String... args) throws Exception {

        /*
        Direction direction = new Direction("calle 554", "712", "1888", "Pavilion Zona Sur", "14", "Zona Sur");
        Pavilion pavilion_zona_sur = new Pavilion(null, 4.0, "Pavilion Zona Sur", direction);

        pavilionDAO.save(pavilion_zona_sur);

        (pavilionDAO.findPavilionsByDirection_Location("FV")).forEach(System.out::println);
        (pavilionDAO.findPavilionsByDirection_Location("Zona Sur")).forEach(System.out::println);

        (pavilionDAO.findPavilionsByName("Pavilion Zona Sur")).forEach(System.out::println);
        (pavilionDAO.findPavilionsByName("Pavilion1")).forEach(System.out::println);
*/
    }
}
