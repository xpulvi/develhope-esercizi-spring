package dev.dmgiangi.APIcustomquery01.repositories;

import dev.dmgiangi.APIcustomquery01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {}
