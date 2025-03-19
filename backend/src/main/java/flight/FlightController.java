package flight;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    // Get all flights
    @RequestMapping
    public List<Flight> getFlights() {
        return flightService.getFlights();
    }

    // Get flights by origin and destination
    @RequestMapping("/origin/{origin}/destination/{destination}")
    public List<Flight> getFlightsByOriginAndDestination(@PathVariable String origin, @PathVariable String destination) {
        return flightService.getFlightsByOriginAndDestination(origin, destination);
    }

    // Get flights by departure time
    @RequestMapping("/departureTimeAfter/{departureTimeAfter}/departureTimeBefore/{departureTimeBefore}")
    public List<Flight> getFlightsByDepartureTime(@PathVariable String departureTimeAfter, @PathVariable String departureTimeBefore) {
        return flightService.getFlightsByDepartureTime(departureTimeAfter, departureTimeBefore);
    }
}
