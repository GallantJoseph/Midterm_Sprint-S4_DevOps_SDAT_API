package rest.airport;

import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends org.springframework.data.repository.CrudRepository<Airport, Long>  {

}
