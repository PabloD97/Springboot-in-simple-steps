package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.exception.BadRequestException;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/careers")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "false")
public class CareerController extends GenericController<Career, CareerDAO>{


    @Autowired
    public CareerController(CareerDAO service){
        super(service);
        this.nameEntity = "Career";
    }


    @PostMapping("/create")
    public ResponseEntity<?> createEntity(@Valid @RequestBody Career career, BindingResult result){

        Map<String, Object> validations = new HashMap<>();
        if(result.hasErrors()){
            result.getFieldErrors().forEach(error -> validations.put(error.getField(), error.getDefaultMessage()) );
            return ResponseEntity.badRequest().body(validations);
        }
        return ResponseEntity.ok(service.save(career));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCareer(@PathVariable Integer id, @RequestBody Career career){
        Map<String, Object> message = new HashMap<>();
        Career careerUpdate;
        Optional<Career> optionalCareer = service.findById(id);
        if(!optionalCareer.isPresent()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("%s whit ID %d does not exist", nameEntity, id));
            return ResponseEntity.badRequest().body(message);
        }
        careerUpdate = optionalCareer.get();
        careerUpdate.setAmountOfYears(career.getAmountOfYears());
        careerUpdate.setAmountOfMaterials(career.getAmountOfMaterials());

        message.put("success", Boolean.TRUE);
        message.put("data",service.save(careerUpdate));
        return ResponseEntity.ok(message);
    }

    @GetMapping("/name-contains/{name}")
    public ResponseEntity<?> getCareersByNameContains(@PathVariable String name){
        Map<String, Object> message = new HashMap<>();
        List<Career> careerList = (List<Career>) service.findCareersByNameContains(name);
        return getResponseEntity(name, message, careerList);
    }


    @GetMapping("/name-contains-ignore-case/{name}")
    public ResponseEntity<?> getCareersByNameContainsIgnoreCase(@PathVariable String name){
        Map<String, Object> message = new HashMap<>();
        List<Career> careerList = (List<Career>) service.findCareersByNameContainsIgnoreCase(name);
        return getResponseEntity(name, message, careerList);
    }

    private ResponseEntity<?> getResponseEntity(@PathVariable String name, Map<String, Object> message, List<Career> careerList) {
        if(careerList.isEmpty()){
            message.put("success", Boolean.FALSE);
            message.put("message", String.format("There are no careers that contain that name: %n", name ));
            return ResponseEntity.badRequest().body(message);
        }
        message.put("success", Boolean.TRUE);
        message.put("data",careerList);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/careerTechearNameLastname")
    public ResponseEntity<?> getCareersTeacherByNameAndLastname(@RequestParam String name, @RequestParam String lastname){
        Map<String, Object> message = new HashMap<>();
        List<Career> careerList = (List<Career>) service.findCareersByTeachersNameAndLastname(name,lastname);
        return getResponseEntity(name, message, careerList);

    }



}
