package com.springboot.universidad.universidadbackend.controller.dto;

import com.springboot.universidad.universidadbackend.model.dto.CareerDTO;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import com.springboot.universidad.universidadbackend.model.mapper.CareerMapper;
import com.springboot.universidad.universidadbackend.services.contracts.CareerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/careers")
@ConditionalOnProperty(prefix = "app", name = "controller.enable-dto", havingValue = "true")
public class CareerDTOController {

    @Autowired
    private CareerDAO careerDAO;

    @GetMapping
    public ResponseEntity<?> getAll(){
        Map<String, Object> message = new HashMap<>();
        List<Career> all = (List<Career>) careerDAO.findAll();
        List<CareerDTO> careerDTOS = all
                .stream()
                .map(CareerMapper::mapCareer)
                .collect(Collectors.toList());
        message.put("success", Boolean.TRUE);
        message.put("data",careerDTOS);
        return ResponseEntity.ok(message);
    }
}
