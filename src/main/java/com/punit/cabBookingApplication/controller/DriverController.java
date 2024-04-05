package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.model.Driver;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverController {

    @PostMapping
    public Driver createDriver(@RequestBody Driver driver) {
        return driver;
    }
}
