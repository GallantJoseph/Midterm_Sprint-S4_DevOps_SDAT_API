package rest.aircraft;

import jakarta.persistence.*;
import rest.airport.Airport;
import rest.passenger.Passenger;

import java.util.List;

@Entity
public class Aircraft {
    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aircraft_sequence")
    private Long id;

    private String type;
    private String airlineName;
    private int numberOfPassengers;

    @ManyToMany
    private List<Passenger> passengers;

    @ManyToMany
    private List<Airport> airports;

    public Aircraft() {
    }
    
    public Aircraft(String type, String airlineName, int numberOfPassengers) {
        this.type = type;
        this.airlineName = airlineName;
        this.numberOfPassengers = numberOfPassengers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Airport> getAirport() {
        return airports;
    }

    public void setAirport(List<Airport> airports) {
        this.airports = airports;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }
}
