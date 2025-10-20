package rest.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cities")
@CrossOrigin
public class CityController {
    
    @Autowired
    private CityService cityService;
    
}
