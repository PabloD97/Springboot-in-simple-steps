package com.springboot.universidad.universidadbackend.controller;

import com.springboot.universidad.universidadbackend.model.entities.Person;
import com.springboot.universidad.universidadbackend.model.entities.enumerators.TypeEmployee;
import com.springboot.universidad.universidadbackend.services.contracts.EmployeeDAO;
import com.springboot.universidad.universidadbackend.services.contracts.PersonDAO;
import com.springboot.universidad.universidadbackend.services.implementations.EmployeeDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends PersonController{

    @Autowired
    public EmployeeController(@Qualifier("employeeDAOImpl") PersonDAO service) {
        super(service);
        nameEntity = "Employee";
    }


    private HashMap<String, Object> getMessage(Boolean bolean, String msj, Object o){
        HashMap<String, Object> message = new HashMap<>();
        message.put("success", bolean);
        message.put(msj, o);
        return message;
    }

    @GetMapping("/employeesByType/{typeEmployee}")
    public ResponseEntity<?> findEmployeesByType(@PathVariable TypeEmployee typeEmployee){
        List<Person> employeesByTypeEmployee = (List<Person>)((EmployeeDAOImpl) service).findEmployeesByTypeEmployee(typeEmployee);
        if(employeesByTypeEmployee.isEmpty()){
            return ResponseEntity.badRequest().body(
                    getMessage(
                            Boolean.FALSE,
                            "message",
                            String.format("There are no such employees: %n", typeEmployee)
                    )
            );
        }
        return ResponseEntity.ok(
                getMessage(
                        Boolean.TRUE,
                        "data",
                        employeesByTypeEmployee
                )
        );
    }

    @PutMapping("/assingPavilion/{idEmployee}/pavilion/{idPavilion}")
    public ResponseEntity<?> setPavilionToEmployee(@PathVariable Integer idEmployee, @PathVariable Integer idPavilion){
        Person employee = ((EmployeeDAOImpl)service).assignPavilion(idEmployee, idPavilion);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
