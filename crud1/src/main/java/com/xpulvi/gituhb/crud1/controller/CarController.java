package com.xpulvi.gituhb.crud1.controller;

import com.xpulvi.gituhb.crud1.entitis.Car;
import com.xpulvi.gituhb.crud1.repository.CarIRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarIRepository carIRepository;

    // create a new Car | salva su db
    @PostMapping
    public Car car(@RequestBody Car car){
        Car carSave = carIRepository.saveAndFlush(car);
        return carSave;
    }

    //return a list of all the Cars | list auto
    @GetMapping
    public List<Car> get(){
        List<Car> carList = carIRepository.findAll();
        return carList;
    }

    /*return a single Car - if the id is not in the db (use existsById()), returns an empty Car
    | prende una singloa car dal lista */
    @GetMapping("/{id}")
    public Car getSigleCar(@PathVariable Long id){
        Car car = carIRepository.getReferenceById(id);
        if(!carIRepository.existsById(id)){
            return null;
        }else{
            return car;
        }
    }
    /*updates the type of a specific Car,
    identified by id and passing a query param - if not present in the db,
     returns an empty Car | 
     */
    @PutMapping("/{id}")
    public Car carUpdate(@PathVariable Long id, @RequestParam String type){
        Car car;
        if(carIRepository.existsById(id)){
            car = carIRepository.getReferenceById(id);
            car.setType(type);
            car = carIRepository.saveAndFlush(car);
        }else{
            car = new Car();
        }
        System.out.println("empty Car");
        return car;
    }

    @DeleteMapping("/id")
    public void  deleteCar(@PathVariable Long id, HttpServletResponse response){
        if(carIRepository.existsById(id)){
           carIRepository.deleteById(id);
            System.out.println("Car delete");
        }else{
            response.setStatus(HttpServletResponse.SC_CONFLICT);
    }
    }

    @DeleteMapping("")
    public void  deleteAllCars(){
        carIRepository.deleteAll();
    }

}
