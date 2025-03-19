package flight;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FlightService {
    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    // Get all flights
    public List<Flight> getFlights() {
        return flightRepository.findAll();
    }

    // Get flights by origin and destination
    public List<Flight> getFlightsByOriginAndDestination(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    // Get flights by departure time
    public List<Flight> getFlightsByDepartureTime(String departureTimeAfterString, String departureTimeBeforeString) {
        LocalDateTime departureTimeAfter = LocalDateTime.parse(departureTimeAfterString);
        LocalDateTime departureTimeBefore = LocalDateTime.parse(departureTimeBeforeString);
        return flightRepository.findByDepartureTimeBetween(departureTimeAfter, departureTimeBefore);
    }
}
