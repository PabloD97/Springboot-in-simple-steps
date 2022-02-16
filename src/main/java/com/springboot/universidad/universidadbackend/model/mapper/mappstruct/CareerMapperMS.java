package com.springboot.universidad.universidadbackend.model.mapper.mappstruct;

import com.springboot.universidad.universidadbackend.model.dto.CareerDTO;
import com.springboot.universidad.universidadbackend.model.entities.Career;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CareerMapperMS {

    /** MapStruct lo que hace es machear los atributos que tengan el mismo nombre**/

    @Mappings({
            @Mapping(source = "id", target = "code"),
            @Mapping(source = "amountOfMaterials", target = "amount_materials"),
            @Mapping(source = "amountOfYears", target = "amount_years"),
    })
    CareerDTO mapCareer(Career career);
}
