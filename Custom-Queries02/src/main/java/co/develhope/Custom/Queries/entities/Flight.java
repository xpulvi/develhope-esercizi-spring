package co.develhope.Custom.Queries.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String description;
    private AirportCode fromAirport;
    private AirportCode toAirport;
    private FlightStatus status;

    public long getId() {
        return id;
    }

    public Flight setId(long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Flight setDescription(String description) {
        this.description = description;
        return this;
    }

    public AirportCode getFromAirport() {
        return fromAirport;
    }

    public Flight setFromAirport(AirportCode fromAirport) {
        this.fromAirport = fromAirport;
        return this;
    }

    public AirportCode getToAirport() {
        return toAirport;
    }

    public Flight setToAirport(AirportCode toAirport) {
        this.toAirport = toAirport;
        return this;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public Flight setStatus(FlightStatus status) {
        this.status = status;
        return this;
    }



    public static Flight randomFlight (){
        return new Flight()
                .setDescription(UUID.randomUUID().toString())
                .setFromAirport(AirportCode.randomCode())
                .setToAirport(AirportCode.randomCode())
                .setStatus(FlightStatus.randomStatus());
    }
}
