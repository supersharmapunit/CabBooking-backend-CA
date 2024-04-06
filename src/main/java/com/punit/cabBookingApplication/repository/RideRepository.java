package com.punit.cabBookingApplication.repository;

import com.punit.cabBookingApplication.model.Ride;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class RideRepository {
    Map<String, Ride> rides;

    public RideRepository() {
        this.rides = new HashMap<>();
    }

    public void addRide(Ride ride) {
        rides.put(ride.getRideId(), ride);
    }

    public Ride getRide(String rideId) {
        return rides.get(rideId);
    }

    public Map<String, Ride> getRides() {
        return rides;
    }

    public boolean rideExists(String rideId) {
        return rides.containsKey(rideId);
    }

    public Ride getRideByDriverId(String driverId) {
        UUID id = UUID.fromString(driverId);
        for(Ride ride: rides.values()) {
            UUID userUUID = UUID.fromString(ride.getDriverId());
            if(userUUID.equals(id)) {
                return ride;
            }
        }
        return null;
    }

    public void removeRideByUserIdAndDriverId(String userId, String driverId) {
        UUID userIdUUID = UUID.fromString(userId);
        UUID driverIdUUID = UUID.fromString(driverId);
        for(Ride ride: rides.values()) {
            UUID userUUID = UUID.fromString(ride.getUserId());
            UUID driverUUID = UUID.fromString(ride.getDriverId());
            if(userUUID.equals(userIdUUID) && driverUUID.equals(driverIdUUID)) {
                rides.remove(ride.getRideId());
            }
        }
    }
}
