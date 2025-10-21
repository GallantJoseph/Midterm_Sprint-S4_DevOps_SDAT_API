package rest.passenger;

import jakarta.persistence.*;
import rest.aircraft.Aircraft;
import rest.city.City;

import java.util.List;

@Entity
public class Passenger {
    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1)
    @GeneratedValue(generator = "city_sequence")

    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    @ManyToOne
    private City city;

    @ManyToMany
    private List<Aircraft> aircraftList;

    public Passenger() {

    }

    public Passenger(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Aircraft> getAircraft() {
        return aircraftList;
    }

    public void setAircraft(List<Aircraft> aircraftList) {
        this.aircraftList = aircraftList;
    }
}
