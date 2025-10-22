package rest.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public Iterable<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    public Optional<Airport> getAirport(long id) {
        return airportRepository.findById(id);
    }

    public Airport addNewAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public Optional<Airport> removeAirport(long id) {
        Optional<Airport> deleted = airportRepository.findById(id);
        airportRepository.deleteById(id);
        return deleted;
    }

    public Optional<Airport> updateAirport(long id, Airport airport) {
        Optional<Airport> airportFromDB = airportRepository.findById(id);
        if (airportFromDB.isPresent()) {
            Airport airportToUpdate = airportFromDB.get();
            airportToUpdate.setName(airport.getName());
            airportToUpdate.setCity(airport.getCity());
            airportToUpdate.setCode(airport.getCode());
            airportToUpdate.setAircraftList(airport.getAircraftList());

            airportRepository.save(airportToUpdate);
        }
        return airportRepository.findById(id);
    }
}
