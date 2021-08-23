package cab.booking.system.src.main.java.com.transportation.cab.booking.system.controllers;

import com.transportation.cab.booking.system.database.CabsManager;
import com.transportation.cab.booking.system.database.TripsManager;
import com.transportation.cab.booking.system.model.Cab;
import com.transportation.cab.booking.system.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
public class CabsController {

    private CabsManager cabsManager;
    private TripsManager tripsManager;

    public CabsController(@NotNull final CabsManager cabsManager, @NotNull final TripsManager tripsManager) {
        this.cabsManager = cabsManager;
        this.tripsManager = tripsManager;
    }

    // Register a cab
    @PostMapping("/register/cab")
    ResponseEntity<String> registerCab(@NotNull final String cabId, @NotNull final String driverName) {
        Cab newCab = new Cab(cabId, driverName);
        cabsManager.createCab(newCab);

        return ResponseEntity.ok("");
    }

    // Update cab availability
    @PostMapping("update/cab/availability")
    ResponseEntity<String> updateCabAvailability(@NotNull final String cabId, @NotNull final boolean newAvailability) {
        cabsManager.updateCabAvailability(cabId, newAvailability);

        return ResponseEntity.ok("");
    }

    // Update cab location
    @PostMapping("update/cab/location")
    ResponseEntity<String> updateCabLocation(@NotNull final String cabId, Location newLocation) {
        cabsManager.updateCabLocation(cabId, newLocation);

        return ResponseEntity.ok("");
    }

    // End trip
    @PostMapping("update/cab/end/trip")
    ResponseEntity<String> endTrip(@NotNull final String cabId) {
        Cab cab = cabsManager.getCab(cabId);
        tripsManager.endTrip(cab);

        return ResponseEntity.ok("");
    }
}
