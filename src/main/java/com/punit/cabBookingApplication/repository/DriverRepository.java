package com.punit.cabBookingApplication.repository;

import com.punit.cabBookingApplication.model.Driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class DriverRepository {
    private List<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void addDriver(Driver driver) {
        this.drivers.add(driver);
    }

    public Driver getDriver(String driverId) {
        UUID id = UUID.fromString(driverId);
        for (Driver driver : this.drivers) {
            UUID driverUUID = UUID.fromString(driver.getDriverID());
            if (driverUUID.equals(id)) {
                return driver;
            }
        }
        return null;
    }
}
