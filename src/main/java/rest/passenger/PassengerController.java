package rest.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/passengers")
@CrossOrigin
public class PassengerController {
    
    @Autowired
    private PassengerService passengerService;
}
