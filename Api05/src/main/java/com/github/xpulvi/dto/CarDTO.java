package com.github.xpulvi.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class CarDTO {

    @NotBlank(message = "mandatory")
    private String id;
    @NotBlank(message = "mandatory")
    private String modelName;

    private double price;

}
