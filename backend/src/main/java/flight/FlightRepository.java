package flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByDepartureTimeBetween(LocalDateTime departureTimeAfter, LocalDateTime departureTimeBefore);
}
