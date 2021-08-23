package cab.booking.system.src.main.java.com.transportation.cab.booking.system.strategies;

import com.transportation.cab.booking.system.model.Location;

public class PricingStrategyImpl implements PricingStrategy {
    static final Integer PRICE_PER_KM = 10;
    @Override
    public Double calculatePrice(Location fromPoint, Location toPoint) {
        return fromPoint.distance(toPoint) * PRICE_PER_KM;
    }
}