package rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.airport.Airport;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/aircraft")
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping
    public ResponseEntity<Iterable<Aircraft>> getAll(){
        return ResponseEntity.ok(aircraftService.getAllAircraft());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aircraft> getById(@PathVariable Long id){
        Aircraft aircraft = aircraftService.getAircraftById(id);
        if (aircraft == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(aircraft);
    }

    @PostMapping
    public ResponseEntity<Aircraft> create(@RequestBody Aircraft aircraft){
        return ResponseEntity.ok(aircraftService.createAircraft(aircraft));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aircraft> update(@PathVariable Long id, @RequestBody Aircraft aircraft){
        Aircraft updated = aircraftService.updateAircraft(id, aircraft);
        if (updated == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
        return ResponseEntity.noContent().build();
    }

    // Question 2 Aircraft by passenger
    @GetMapping("/passenger/{id}")
    public ResponseEntity<Iterable<Aircraft>> getByPassenger(@PathVariable Long id){
        return ResponseEntity.ok(aircraftService.getAllAircraftByPassengerId(id));
    }

    // Question 3 Airports by aircraft
    @GetMapping("/{id}/airports")
    public ResponseEntity<List<Airport>> getAirports(@PathVariable Long id){
        List<Airport> airport = aircraftService.getAirportsByAircraft(id);
        if (airport == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(airport);
    }

    // we need this for Question 3
    @PostMapping("/{id}/airports/{airportId}")
    public ResponseEntity<Void> addAirport(@PathVariable Long id, @PathVariable Long airportId){
        aircraftService.addAirportToAircraft(id, airportId);
        return ResponseEntity.ok().build();
    }

    // Question 2 Aircraft by passenger
    @PostMapping("/{id}/passengers/{passengerId}")
    public ResponseEntity<Void> addPassenger(@PathVariable Long id, @PathVariable Long passengerId){
        aircraftService.addPassengerToAircraft(id, passengerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/passengers/{passengerId}")
    public ResponseEntity<Void> removePassengerFromAircraft(@PathVariable Long id, @PathVariable Long passengerId){
        aircraftService.removePassengerFromAircraft(id, passengerId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/airports/{airportId}")
    public ResponseEntity<Void> removeAirportFromAircraft(@PathVariable Long id, @PathVariable Long airportId){
        aircraftService.removeAirportFromAircraft(id, airportId);
        return ResponseEntity.ok().build();
    }

    // Question 4
    @GetMapping("/passengers/airports")
    public Set<Airport> getAirportsUsedByAllPassengers() {
        return aircraftService.getAirportsUsedByAllPassengers();
    }
}