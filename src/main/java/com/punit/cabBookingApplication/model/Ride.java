package com.punit.cabBookingApplication.model;

import com.punit.cabBookingApplication.util.helper.Location;
import com.punit.cabBookingApplication.util.helper.RideStatus;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class Ride {
    private String rideId;
    private String userId;
    private String driverId;
    private Location source;
    private Location destination;
    private RideStatus status;

    public Ride(String userId, String driverId, Location source, Location destination, RideStatus status) {
        this.rideId = UUID.randomUUID().toString();
        this.userId = userId;
        this.driverId = driverId;
        this.source = source;
        this.destination = destination;
        this.status = status;
    }
}
