package rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/aircraft")
@CrossOrigin
public class AircraftController {
    
    @Autowired
    private AircraftService aircraftService;
}
