package rest.aircraft;

import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends org.springframework.data.repository.CrudRepository<Aircraft, Long>  {

}
