package cab.booking.system.src.main.java.com.transportation.cab.booking.system.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Cab {
    String id;
    String driverName;

    @Setter Trip currentTrip;
    @Setter Location currentLocation;
    @Setter boolean isAvailable;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
    }
}
