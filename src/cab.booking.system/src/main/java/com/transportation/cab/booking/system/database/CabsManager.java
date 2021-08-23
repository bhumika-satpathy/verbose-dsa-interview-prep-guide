package cab.booking.system.src.main.java.com.transportation.cab.booking.system.database;

import com.sun.istack.internal.NotNull;
import com.transportation.cab.booking.system.model.Cab;
import com.transportation.cab.booking.system.model.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Responsibility is to manage the incoming and outgoing cab details
public class CabsManager {
    // Store cabs in-memory: In a hash map
    HashMap<String, Cab> cabs = new HashMap<>();

    // Register a cab into the can register
    public void createCab(Cab newCab) {
        if(cabs.containsKey(newCab.getId())) {
            // Throw cab already exists exception
        }
        cabs.put(newCab.getId(), newCab);
    }

    // Get a cab
    public Cab getCab(@NotNull String cabId) {
        if(!cabs.containsKey(cabId)) {
            // Throw cab not found exception
        }
        return cabs.get(cabId);
    }

    // Update cab availability
    public void updateCabAvailability(@NotNull String cabId, @NotNull boolean newAvailabilty) {
        if(!cabs.containsKey(cabId)) {
            // Throw cab not found exception
        }

        cabs.get(cabId).setAvailable(newAvailabilty);
    }

    // Update cab location
    public void updateCabLocation(@NotNull String cabId, @NotNull Location newLocation) {
        if(!cabs.containsKey(cabId)) {
            // Throw cab not found exception
        }

        cabs.get(cabId).setCurrentLocation(newLocation);
    }

    // Get all available cabs within a distance of 'distance' from fromPoint
    List<Cab> getCabs(@NotNull final Location fromPoint, @NotNull final Double distance) {
        List<Cab> result = new ArrayList<>();
        for(Cab cab: cabs.values()) {
            if(cab.isAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance) {
                result.add(cab);
            }
        }
        return result;
    }
}
