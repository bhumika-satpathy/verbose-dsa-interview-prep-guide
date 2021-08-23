package cab.booking.system.src.main.java.com.transportation.cab.booking.system.strategies;

import com.transportation.cab.booking.system.model.Cab;
import com.transportation.cab.booking.system.model.Location;
import com.transportation.cab.booking.system.model.Rider;

import java.util.List;

public interface CabMatchingStrategy {
    Cab matchCabToRider(Rider rider, Location fromPoint, Location toPoint, List<Cab> cabsNearBy);
}
