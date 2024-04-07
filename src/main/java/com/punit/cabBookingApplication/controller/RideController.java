package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.FindRideRequestDTO;
import com.punit.cabBookingApplication.dto.ResponseDTO;
import com.punit.cabBookingApplication.exception.DriverNotFoundException;
import com.punit.cabBookingApplication.exception.NoRidesAvailableException;
import com.punit.cabBookingApplication.exception.UserNotFoundException;
import com.punit.cabBookingApplication.service.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ride")
public class RideController {
    @Autowired
    private RideService rideService;

    @PostMapping("/find")
    public ResponseEntity<ResponseDTO> findRides(@RequestBody FindRideRequestDTO findRideRequestDTO) {
        try {
            return ResponseEntity.ok().body(
              new ResponseDTO(true, "Rides found successfully", this.rideService.findRides(findRideRequestDTO), null)
            );
        } catch (Exception e) {
            if(e instanceof NoRidesAvailableException) {
                return ResponseEntity.status(404).body(
                  new ResponseDTO(false, "Rides not found", null, e.getMessage())
                );
            } else if (e instanceof DriverNotFoundException || e instanceof UserNotFoundException) {
                return ResponseEntity.badRequest().body(
                  new ResponseDTO(false, "wrong inputs", null, e.getMessage())
                );
            }
            return ResponseEntity.internalServerError().body(
              new ResponseDTO(false, "Rides not found", null, e.getMessage())
            );
        }
    }

    @PostMapping("/choose")
    public ResponseEntity<ResponseDTO> chooseARide(@RequestParam String userId, @RequestParam String driverId) {
        try {
            return ResponseEntity.ok().body(
                    new ResponseDTO(true, "ride booked successfully", this.rideService.chooseRide(userId, driverId), null)
            );
        } catch (Exception e) {
            if(e instanceof NoRidesAvailableException) {
                return ResponseEntity.status(404).body(
                        new ResponseDTO(false, "error in booking ride", null, e.getMessage())
                );
            } else if (e instanceof DriverNotFoundException || e instanceof UserNotFoundException) {
                return ResponseEntity.badRequest().body(
                        new ResponseDTO(false, "wrong inputs", null, e.getMessage())
                );
            }
            return ResponseEntity.internalServerError().body(
                    new ResponseDTO(false, "error in booking ride", null, e.getMessage())
            );
        }
    }
}