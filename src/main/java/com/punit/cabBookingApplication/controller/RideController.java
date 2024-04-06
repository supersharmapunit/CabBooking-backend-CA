package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.FindRideRequestDTO;
import com.punit.cabBookingApplication.model.Ride;
import com.punit.cabBookingApplication.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ride")
public class RideController {
    @Autowired
    private RideService rideService;

    @PostMapping("/find")
    public List<Ride> findRides(@RequestBody FindRideRequestDTO findRideRequestDTO) {
        return this.rideService.findRides(findRideRequestDTO);
    }

    @PostMapping("/choose")
    public Ride chooseARide(@RequestParam String userId, @RequestParam String driverId) {
        return this.rideService.chooseRide(userId, driverId);
    }
}