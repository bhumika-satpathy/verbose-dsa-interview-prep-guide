package cab.booking.system.src.main.java.com.transportation.cab.booking.system.controllers;

import com.transportation.cab.booking.system.database.RidersManager;
import com.transportation.cab.booking.system.database.TripsManager;
import com.transportation.cab.booking.system.model.Location;
import com.transportation.cab.booking.system.model.Rider;
import com.transportation.cab.booking.system.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class RidersController {

    private RidersManager ridersManager;
    private TripsManager tripsManager;

    public RidersController(@NotNull final RidersManager ridersManager, @NotNull final TripsManager tripsManager) {
        this.ridersManager = ridersManager;
        this.tripsManager = tripsManager;
    }

    // Register a ride
    @PostMapping("create/rider")
    ResponseEntity<String> registerRide(@NotNull final String riderId, @NotNull final String riderName) {
        Rider newRider = new Rider(riderId, riderName);

        ridersManager.createRider(newRider);
        return ResponseEntity.ok("");
    }

    // Create/Book a ride
    @PostMapping("create/ride")
    ResponseEntity<String> bookNewRide(@NotNull final String riderId, Location fromPoint, Location toPoint) {
        Rider rider = ridersManager.getRider(riderId);
        tripsManager.createTrip(rider, fromPoint, toPoint);

        return ResponseEntity.ok("");
    }

    // Fetch the list of rides made in the past
    @GetMapping("previous/rides")
    ResponseEntity<String> fetchPreviousRides(@NotNull final String riderId) {
        List<Trip> trips = tripsManager.getPreviousRides(riderId);
        return ResponseEntity.ok("");
    }
}
