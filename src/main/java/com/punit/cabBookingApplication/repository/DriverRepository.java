package com.punit.cabBookingApplication.repository;

import com.punit.cabBookingApplication.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverRepository {
    private List<Driver> drivers;

    public DriverRepository() {
        this.drivers = new ArrayList<>();
    }

    public List<Driver> driverDB() {
        return this.drivers;
    }
}
