package cab.booking.system.src.main.java.com.transportation.cab.booking.system.model;

import com.sun.istack.internal.NotNull;

enum TripStatus {
    IN_PROGRESS,
    FINISHED
}
public class Trip {
    private Rider rider;
    private Cab cab;
    private Location startLocation;
    private Location endLocation;
    private TripStatus status;
    private Double price;

    public Trip(
            @NotNull final Rider rider,
            @NotNull final Cab cab,
            @NotNull final Location startLocation,
            @NotNull final Location endLocation,
            @NotNull final Double price
    ) {
        this.rider = rider;
        this.cab = cab;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.status = TripStatus.IN_PROGRESS;
        this.price = price;
    }

    public void endTrip() {
        this.status = TripStatus.FINISHED;
    }
}
