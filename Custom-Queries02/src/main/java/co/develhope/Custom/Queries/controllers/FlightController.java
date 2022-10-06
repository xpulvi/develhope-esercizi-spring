package co.develhope.Custom.Queries.controllers;

import co.develhope.Custom.Queries.entities.Flight;
import co.develhope.Custom.Queries.entities.FlightStatus;
import co.develhope.Custom.Queries.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @PostMapping
    public List<Flight> createFlights(@RequestParam(required = false, defaultValue = "100") String flightNumber){

        int number;
        try{
            number = Integer.parseInt(flightNumber);
        }catch(NumberFormatException n) {
            number = 100;
        }

        List<Flight> flightList= new ArrayList<>();
        for (int i = 0; i < number; i++) {
            flightList.add(Flight.randomFlight());
        }
        flightRepository.saveAllAndFlush(flightList);
        return flightList;
    }

    @GetMapping
    public Page<Flight> getAllFlights(
            @RequestParam(required = false, defaultValue = "0") String page,
            @RequestParam(required = false, defaultValue = "100") String size){
        int pageNumber;
        try{
            pageNumber = Integer.parseInt(page);
        }catch(NumberFormatException n) {
            pageNumber = 0;
        }
        int sizeNumber;
        try{
            sizeNumber = Integer.parseInt(size);
        }catch(NumberFormatException n) {
            sizeNumber = 100;
        }
        Pageable pageable = PageRequest.of(pageNumber, sizeNumber, Sort.by("fromAirport").ascending());
        return flightRepository.findAll(pageable);
    }

    @GetMapping("/ontime")
    public List<Flight> getOntimeFlights(){
        return flightRepository.findAllByStatus(FlightStatus.ONTIME);
    }

    @GetMapping("/custom")
    public List<Flight> getCustomStatusFlights(@RequestParam(name = "p1") String status1,
                                               @RequestParam(name = "p2") String status2){

        FlightStatus flightStatus1 = FlightStatus.fromString(status1);

        FlightStatus flightStatus2 = FlightStatus.fromString(status2);

        return flightRepository.findAllByStatus(flightStatus1, flightStatus2);
    }

}
