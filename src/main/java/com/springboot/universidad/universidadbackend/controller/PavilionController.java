package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.model.entities.Pavilion;
import com.springboot.universidad.universidadbackend.services.contracts.GenericDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PavilionDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/pavilions")
public class PavilionController extends GenericController<Pavilion, PavilionDAO> {

    @Autowired
    public PavilionController(PavilionDAO service) {
        super(service);
        nameEntity = "Pavilion";
    }

    private HashMap<String, Object> getMessage(Boolean bolean, String msj, Object o){
        HashMap<String, Object> message = new HashMap<>();
        message.put("success", bolean);
        message.put(msj, o);
        return message;
    }

    @GetMapping("/findByLocation/{location}")
    public ResponseEntity getPavilionsByLocation(@PathVariable String location){
        List<Pavilion> pavilionList = (List<Pavilion>) service.findPavilionsByDirection_Location(location);
        if(pavilionList.isEmpty()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("There are no pavilions with that location: %l", location)
                    )
            );
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                pavilionList
        ));
    }

    @GetMapping("/findByNameIgnoreCase/{name}")
    public ResponseEntity getNameIgnoreCase(@PathVariable String name){
        List<Pavilion> pavilionsByName = (List<Pavilion>) service.findPavilionsByName(name);
        if(pavilionsByName.isEmpty()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("There are no pavilions with that name: %n", name)
                    )
            );
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                pavilionsByName
        ));
    }

}
