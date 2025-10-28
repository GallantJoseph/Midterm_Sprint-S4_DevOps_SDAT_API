package rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.airport.Airport;

import java.util.List;


@RestController
@RequestMapping({"/aircraft"})
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping({""})
    public ResponseEntity<Iterable<Aircraft>> getAllAircraft(){
        return ResponseEntity.ok(aircraftService.getAllAircraft());
    }

    @GetMapping({"/passenger/{id}"})
    public Iterable<Aircraft> getAllAircraftByPassengerId(@PathVariable Long id){
        return aircraftService.getAllAircraftByPassengerId(id);
    }

    @GetMapping({"/{id}"})
        public ResponseEntity<Aircraft> getAircraftById(@PathVariable Long id){
        return ResponseEntity.ok(aircraftService.getAircraftById(id));
        }

    @PostMapping({""})
    public ResponseEntity<Aircraft> createAircraft(@RequestBody Aircraft aircraft){
        return ResponseEntity.ok(aircraftService.createAircraft(aircraft));
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<Aircraft> updateAircraft(@PathVariable Long id, @RequestBody Aircraft aircraft){
        return ResponseEntity.ok(aircraftService.updateAircraft(id, aircraft));
    }
    @DeleteMapping({"/{id}"})
    public void deleteAircraftById(@PathVariable Long id){
        aircraftService.deleteAircraftById(id);
    }

    // TODO ********** REVIEW WITH TEAM TO FIX *********

    @GetMapping({"/{id}/airports"})
    public ResponseEntity<List<Airport>> getAirportsByAircraft(@PathVariable Long id){
        return ResponseEntity.ok(aircraftService.getAirportsByAircraft(id));
    }

    // we need this for Question 3
    @PostMapping({"/{id}/airports/{airportId}"})
    public void addAirportToAircraft(@PathVariable Long id, @PathVariable Long airportId){
        aircraftService.addAirportToAircraft(id, airportId);
    }
}
