package com.punit.cabBookingApplication.repository;

import com.punit.cabBookingApplication.model.Ride;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class RideRepository {
    List<Ride> rides;

    public RideRepository() {
        this.rides = new ArrayList<>();
    }

    public void addRide(Ride ride) {
        rides.add(ride);
    }

    public Ride getRide(String rideId) {
        for(Ride ride: rides) {
            if(ride.getRideId().equals(rideId)) {
                return ride;
            }
        }
        return null;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public Ride getRideByDriverId(String driverId) {
        UUID id = UUID.fromString(driverId);
        for(Ride ride: rides) {
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
        for(Ride ride: rides) {
            UUID userUUID = UUID.fromString(ride.getUserId());
            UUID driverUUID = UUID.fromString(ride.getDriverId());
            if(userUUID.equals(userIdUUID) && driverUUID.equals(driverIdUUID)) {
                rides.remove(ride.getRideId());
            }
        }
    }
}
