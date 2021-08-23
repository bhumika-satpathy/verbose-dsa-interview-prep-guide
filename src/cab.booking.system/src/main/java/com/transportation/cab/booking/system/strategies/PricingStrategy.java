package cab.booking.system.src.main.java.com.transportation.cab.booking.system.strategies;

import com.transportation.cab.booking.system.model.Location;

public interface PricingStrategy {
    Double calculatePrice(Location fromPoint, Location toPoint);
}
