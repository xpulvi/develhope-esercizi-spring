package co.develhope.Custom.Queries.repositories;

import co.develhope.Custom.Queries.entities.Flight;
import co.develhope.Custom.Queries.entities.FlightStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    public List<Flight> findAllByStatus(FlightStatus status);

    @Query("SELECT f FROM Flight f WHERE f.status = ?1 OR f.status = ?2")
    public List<Flight> findAllByStatus(FlightStatus status1, FlightStatus status2);

}
