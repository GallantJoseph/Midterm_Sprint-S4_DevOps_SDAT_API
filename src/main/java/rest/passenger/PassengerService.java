package rest.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rest.city.CityService;
import java.util.Optional;

@Service
public class PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private CityService cityService;

    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger getPassengerById(long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Iterable<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger updatePassenger(long id, Passenger updatedPassenger) {
        Optional<Passenger> passengerToUpdateOptional = passengerRepository.findById(id);

        if (passengerToUpdateOptional.isPresent()) {
            Passenger passengerToUpdate = passengerToUpdateOptional.get();

            passengerToUpdate.setFirstName(updatedPassenger.getFirstName());
            passengerToUpdate.setLastName(updatedPassenger.getLastName());
            passengerToUpdate.setCity(cityService.getCityById(updatedPassenger.getCity().getId()));

            return passengerRepository.save(passengerToUpdate);
        }

        return null;
    }

    public void deletePassenger(long id) {
        passengerRepository.deleteById(id);
    }
}
