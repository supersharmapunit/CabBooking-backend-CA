package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.DriverDTO;
import com.punit.cabBookingApplication.model.Driver;
import com.punit.cabBookingApplication.util.helper.Location;

import java.util.List;

public interface DriverService {
    public String addDriver(DriverDTO driverDTO);
    public Driver getDriverById(String id);
    public List<Driver> getAvailableDrivers(Location userLocation, int maxDistance);
}
