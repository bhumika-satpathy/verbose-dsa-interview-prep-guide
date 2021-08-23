package cab.booking.system.src.main.java.com.transportation.cab.booking.system.database;

import com.sun.istack.internal.NotNull;
import com.transportation.cab.booking.system.model.Cab;
import com.transportation.cab.booking.system.model.Location;
import com.transportation.cab.booking.system.model.Rider;
import com.transportation.cab.booking.system.model.Trip;
import com.transportation.cab.booking.system.strategies.CabMatchingStrategy;
import com.transportation.cab.booking.system.strategies.PricingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TripsManager {
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private HashMap<String, List<Trip>> trips = new HashMap<>();

    private CabsManager cabsManager;
    private RidersManager ridersManager;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;

    public TripsManager(
            CabsManager cabsManager,
            RidersManager ridersManager,
            CabMatchingStrategy cabMatchingStrategy,
            PricingStrategy pricingStrategy
    ) {
        this.cabsManager = cabsManager;
        this.ridersManager = ridersManager;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }

    // Create a trip
    public void createTrip(@NotNull final Rider rider, @NotNull final Location fromPoint, @NotNull final Location toPoint) {

        // Select all the cabs that are near by (includes cabs both which are in trips and without trips)
        List<Cab> cabsNearBy = cabsManager.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);

        // Only select those cabs that are free and do not have a trip currently
        List<Cab> availableCabs = cabsNearBy.stream().filter(cab -> cab.getCurrentTrip() == null).collect(Collectors.toList());

        // Select a cab from the available cabs using the cab matching strategy
        Cab selectedCab = cabMatchingStrategy.matchCabToRider(rider, fromPoint, toPoint, availableCabs);
        if(selectedCab == null) {
            // Throw no cabs available exception
        }

        // Calculate the amount to be charged to the customer for the ride using pricing strategy
        Double priceCharged = pricingStrategy.calculatePrice(fromPoint, toPoint);

        // Create new trip
        Trip newTrip = new Trip(rider, selectedCab, fromPoint, toPoint, priceCharged);

        if(!trips.containsKey(rider.getId())) {
            trips.put(rider.getId(), new ArrayList<>());
        }
        trips.get(rider.getId()).add(newTrip);
        selectedCab.setCurrentTrip(newTrip);
        selectedCab.setAvailable(false);
    }

    // End a trip
    public void endTrip(@NotNull final Cab cab) {
        if(cab.getCurrentTrip() == null) {
            // Throw trip not found exception
        }
        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }

    // Get previous rides of a particular rider
    public List<Trip> getPreviousRides(@NotNull final String riderId) {
        if(trips.get(riderId) == null) {
            // Throw rider not found exception
        }
        return trips.get(riderId);
    }
}
