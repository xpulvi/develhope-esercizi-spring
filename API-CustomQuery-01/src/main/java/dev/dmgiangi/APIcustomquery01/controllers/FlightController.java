package dev.dmgiangi.APIcustomquery01.controllers;

import dev.dmgiangi.APIcustomquery01.entities.Flight;
import dev.dmgiangi.APIcustomquery01.entities.FlightStatus;
import dev.dmgiangi.APIcustomquery01.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.IntStream;

@RestController
@RequestMapping("flights")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @PostMapping
    public List<Flight> createFlights(){
        List<Flight> flights = IntStream.range(1, 51)
                .mapToObj(x -> Flight.randomFlight().setStatus(FlightStatus.ONTIME))
                .toList();
        return flightRepository.saveAllAndFlush(flights);
    }

    @GetMapping
    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }
}
