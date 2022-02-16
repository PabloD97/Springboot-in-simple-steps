package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.exception.BadRequestException;
import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class PersonController extends GenericController<Person, PersonDAO> {


    public PersonController(PersonDAO service) {
        super(service);
    }

    @GetMapping("/name-lastname")
    public ResponseEntity<?> findByNameAndLastname(@RequestParam String name, @RequestParam String lastname){
        Map<String, Object> message = new HashMap<>();
        Optional<Person> oPersona = service.findByNameAndLastname(name,lastname);
        if(!oPersona.isPresent()) {
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("Person whit %n and %l does not exist ", name, lastname));
            return ResponseEntity.badRequest().body(message);
        }

        message.put("success", Boolean.TRUE);
        message.put("data", oPersona.get());
        return ResponseEntity.ok(message);

    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<?> getByDni(@PathVariable String dni){
        Optional<Person> byDni = service.findByDni(dni);
        if (!byDni.isPresent()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("The person with this DNI %s does not exist",dni)
                    )
            );
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                byDni.get()
        ));
    }

    @GetMapping("/lastname/{lastname}")
    public ResponseEntity<?> getPersonByLastname(@PathVariable String lastname){
        List<Person> byLastname = (List<Person>) service.findByLastname(lastname);
        if (byLastname.isEmpty()){
            return ResponseEntity.badRequest().body (
                    getMessage(Boolean.FALSE,
                            "message",
                            "No people with that last name have been found"));
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                byLastname
        ));
    }

    private HashMap<String, Object> getMessage(Boolean bolean, String msj, Object o){
        HashMap<String, Object> message = new HashMap<>();
        message.put("success", bolean);
        message.put(msj, o);
        return message;
    }

}
