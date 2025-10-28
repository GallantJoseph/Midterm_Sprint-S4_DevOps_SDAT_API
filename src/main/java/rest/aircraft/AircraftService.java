package rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.airport.Airport;
import rest.airport.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftService {
    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private AirportRepository airportRepository;

    public Iterable<Aircraft> getAllAircraftByPassengerId (Long passengerId) {
        return aircraftRepository.findAllByPassengers_Id(passengerId);
    }

    public Iterable<Aircraft> getAllAircraft() {
        return  aircraftRepository.findAll();
    }

    public Aircraft getAircraftById(Long id){
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        return aircraftOptional.orElse(null);
    }

    public Aircraft createAircraft(Aircraft newAircraft){
        return aircraftRepository.save(newAircraft);
    }

    // Can change this if we establish new arrayList<> in class files instead of leaving it null.
    public Aircraft updateAircraft(Long id, Aircraft updatedAircraft){
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (aircraftOptional.isPresent()){
            Aircraft aircraftToUpdate = aircraftOptional.get();
            aircraftToUpdate.setType(updatedAircraft.getType());
            aircraftToUpdate.setAirlineName(updatedAircraft.getAirlineName());
            aircraftToUpdate.setNumberOfPassengers(updatedAircraft.getNumberOfPassengers());
            return aircraftRepository.save(aircraftToUpdate);
        } else {
            return null;
        }
    }

    public void deleteAircraftById(Long id){
        aircraftRepository.deleteById(id);
    }

    public List<Airport> getAirportsByAircraft(Long id){
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(id);
        if (aircraftOptional.isPresent()){
            return aircraftOptional.get().getAirports();
        } else {
            return null;
        }
    }

    // can also be fixed if we esablish the new arrayList<> in class files
    public void addAirportToAircraft(Long aircraftId, Long airportId){
        Optional<Aircraft> aircraftOptional = aircraftRepository.findById(aircraftId);
        Optional<Airport> airportOptional = airportRepository.findById(airportId);
        if (aircraftOptional.isPresent() && airportOptional.isPresent()) {
            Aircraft aircraft = aircraftOptional.get();
            Airport airport = airportOptional.get();
            aircraft.getAirports().add(airport);
            aircraftRepository.save(aircraft);
            airportRepository.save(airport);
        }
    }
}
