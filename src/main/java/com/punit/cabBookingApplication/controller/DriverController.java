package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.DriverDTO;
import com.punit.cabBookingApplication.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping
    public String createDriver(@RequestBody DriverDTO driverDto) {
        return this.driverService.addDriver(driverDto);
    }
}
