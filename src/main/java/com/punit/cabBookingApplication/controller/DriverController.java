package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.DriverDTO;
import com.punit.cabBookingApplication.dto.ResponseDTO;
import com.punit.cabBookingApplication.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public ResponseEntity<ResponseDTO> createDriver(@RequestBody DriverDTO driverDto) {
        try {
            return ResponseEntity.status(201).body(
                    new ResponseDTO(true, "Driver created successfully", this.driverService.addDriver(driverDto), null)
            );
        } catch (Exception e) {
            return ResponseEntity.status(400).body(
                    new ResponseDTO(false, "Something went wrong while creating driver", null, e.getMessage())
            );
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllDrivers() {
       try {
           return ResponseEntity.status(200).body(
                   new ResponseDTO(true, "Drivers fetched successfully", this.driverService.getAllDrivers(), null)
           );
       } catch (Exception e) {
           return ResponseEntity.status(400).body(
                   new ResponseDTO(false, "Something went wrong while fetching drivers", null, e.getMessage())
           );
       }
    }
}
