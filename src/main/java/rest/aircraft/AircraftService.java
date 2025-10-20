package rest.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AircraftService {
    @Autowired
    private AircraftController aircraftController;
}
