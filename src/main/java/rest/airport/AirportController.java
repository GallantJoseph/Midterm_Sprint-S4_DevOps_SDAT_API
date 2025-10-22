package rest.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
@CrossOrigin
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    public Iterable<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    public Optional<Airport> getAirport(@PathVariable("id") long id) {
        return airportService.getAirport(id);
    }

    @PostMapping
    public Airport addNewAirport(@RequestBody Airport airport) { return airportService.addNewAirport(airport); }

    @DeleteMapping("/{id}")
    public Optional<Airport> removeAirport(@PathVariable("id") long id) {
        return airportService.removeAirport(id);
    }

    @PutMapping("/{id}")
    public Optional<Airport> updateAirport(@PathVariable("id") long id, @RequestBody Airport airport) {
        return airportService.updateAirport(id, airport);
    }
}
