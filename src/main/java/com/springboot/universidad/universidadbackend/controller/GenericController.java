package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.exception.BadRequestException;
import com.springboot.universidad.universidadbackend.services.contracts.GenericDAO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GenericController <E, S extends GenericDAO<E>> {

    protected final S service;
    protected String nameEntity;

    public GenericController(S service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){ //con <?> decimos que podemos devolver cualquier cosa
        List<E> response = (List<E>) service.findAll();
        if(response.isEmpty()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("%ss does not exist", nameEntity)
                    )
            );
        }

        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                response
        ));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Optional<E> byId = service.findById(id);
        if(!byId.isPresent()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                    Boolean.FALSE,
                    "message",
                    String.format("%ss whit the id: %i  does not exist", nameEntity, id)
            ));
        }
        return ResponseEntity.ok(
                getMessage(
                        Boolean.TRUE,
                        "data",
                        byId.get()
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id){
        Optional<E> e = service.findById(id);
        if(!e.isPresent()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("%ss whit the id: %i  does not exist", nameEntity, id)
                    )
            );
        }
        return ResponseEntity.ok(
                getMessage(
                        Boolean.TRUE,
                        "data",
                        String.format("%ss whit the id: %i he was removed", nameEntity, id)

                )
        );
    }

    @PostMapping
    public ResponseEntity<?> createEntity(@RequestBody E e){
        E save = service.save(e);
        if(save.equals(null)){
            return ResponseEntity.badRequest().body(
              getMessage(
                      Boolean.FALSE,
                      "message",
                      String.format("There was an error creating %n", nameEntity)
              )
            );
        }
        return ResponseEntity.ok(getMessage(
                Boolean.TRUE,
                "data",
                save
        ));
    }


    private HashMap<String, Object> getMessage(Boolean bolean, String msj, Object o){
        HashMap<String, Object> message = new HashMap<>();
        message.put("success", bolean);
        message.put(msj, o);
        return message;
    }
}
