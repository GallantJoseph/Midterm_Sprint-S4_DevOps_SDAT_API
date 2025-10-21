package rest.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCityById(long id) {
        return cityRepository.findById(id).orElse(null);
    }

    public List<City> getAllCities(){
        return (List<City>) cityRepository.findAll();
    }

    public City updateCity(long id, City updatedCity) {
        return cityRepository.findById(id)
                .map(city -> {
                    city.setName(updatedCity.getName());
                    city.setProvince(updatedCity.getProvince());
                    city.setPopulation(updatedCity.getPopulation());
                    return cityRepository.save(city);
                })
                .orElse(null);
    }

    public void deleteCity(long id) {
        cityRepository.deleteById(id);
    }
}
