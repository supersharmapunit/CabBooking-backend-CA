package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.FindRideRequestDTO;
import com.punit.cabBookingApplication.model.Ride;

import java.util.List;

public interface RideService {
    public List<Ride> findRides(FindRideRequestDTO findRideRequestDTO);
    public Ride chooseRide(String userId, String driverId);

    public List<Ride> getRides();
}
