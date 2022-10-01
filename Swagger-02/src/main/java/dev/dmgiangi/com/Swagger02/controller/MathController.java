package dev.dmgiangi.com.Swagger02.controller;

import dev.dmgiangi.com.Swagger02.entity.ArithmeticOperation;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

import static java.lang.Math.sqrt;

@Api(tags = {"math"})
@RestController
@RequestMapping("/math")
public class MathController {
  @GetMapping
  public String welcomeMathMsg() {
    return "Math Controller";
  }

  @GetMapping(path = "division-info")
  public ArithmeticOperation divisionInfo() {
    return new ArithmeticOperation(
        "division",
        2,
        "The division is the process of repetitive subtraction. ",
        Arrays.asList("THE INVARIANT PROPERTY", "THE DISTRIBUTION PROPERTY"));
  }

  @GetMapping(path = "multiplication")
  public String multiplication(
      @RequestParam(required = false) String a, @RequestParam(required = false) String b) {
    if (a == null || b == null) return "a and b are not optional parameter.";
    double aD, bD;
    try {
      aD = Double.parseDouble(a);
      bD = Double.parseDouble(b);
    } catch (NumberFormatException e) {
      return "a and b must be valid number";
    }
    return aD * bD + "";
  }

  @GetMapping("square/{n}")
  public String square(@PathVariable("n") String n) {
    Double nD;
    try {
      nD = Double.parseDouble(n);
    } catch (NumberFormatException e) {
      return "the value in path must be valid number e.g. '.../math/square/53'";
    }
    if (nD < 0)
      return "the number must be positive, but the value of sqrt(-1 * "
          + n
          + ") is "
          + sqrt(nD * -1);
    return sqrt(nD) + "";
  }

  @GetMapping(path = "square")
  public String squareWithoutNumber() {
    return "Should you put a number in path e.g. '.../math/square/53'";
  }
}
