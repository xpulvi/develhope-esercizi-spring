package dev.dmgiangi.com.Swagger02.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@ApiModel
@Data
@AllArgsConstructor
public class ArithmeticOperation {
  @ApiModelProperty(allowEmptyValue = false, example = "division", required = true)
  private String name;

  @ApiModelProperty(allowEmptyValue = false, example = "2", required = true)
  private int minNumberOfOperands;

  @ApiModelProperty(
      allowEmptyValue = false,
      example = "The division is the process of repetitive subtraction.",
      required = true)
  private String description;

  @ApiModelProperty(
      allowEmptyValue = false,
      example = "['properties 1' , 'properties 2']",
      required = false)
  private List<String> Properties;
}
