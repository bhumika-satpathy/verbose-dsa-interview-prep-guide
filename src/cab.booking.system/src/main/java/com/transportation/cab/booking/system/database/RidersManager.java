package cab.booking.system.src.main.java.com.transportation.cab.booking.system.database;

import com.sun.istack.internal.NotNull;
import com.transportation.cab.booking.system.model.Rider;

import java.util.HashMap;

public class RidersManager {
    HashMap<String, Rider> riders = new HashMap<>();

    // Create a rider
    public void createRider(@NotNull final Rider newRider) {
        if(riders.containsKey(newRider.getId())) {
            // Throw rider already exists exception
        }
        riders.put(newRider.getId(), newRider);
    }

    // Get a rider
    public Rider getRider(@NotNull final String riderId) {
        if(!riders.containsKey(riderId)) {
            // Throw rider not found exception
        }
        return riders.get(riderId);
    }
}
