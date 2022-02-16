package com.springboot.universidad.universidadbackend.model.mapper;

import com.springboot.universidad.universidadbackend.model.dto.CareerDTO;
import com.springboot.universidad.universidadbackend.model.entities.Career;

public class CareerMapper {

    public static CareerDTO mapCareer(Career career){
        CareerDTO careerDTO = new CareerDTO();
        careerDTO.setCode(career.getId());
        careerDTO.setName(career.getName());
        careerDTO.setAmount_materials(career.getAmountOfMaterials());
        careerDTO.setAmount_years(career.getAmountOfYears());
        return careerDTO;
    }


}
