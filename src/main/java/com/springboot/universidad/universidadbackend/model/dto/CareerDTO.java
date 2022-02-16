package com.springboot.universidad.universidadbackend.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
/**Lombok nos genera en tiempo de compilacion el codigo
 * necesario para asi tener una clase mas limpia.**/
public class CareerDTO {

    private Integer code;
    private String name;
    private Integer amount_materials;
    private Integer amount_years;


}

