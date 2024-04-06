package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.DriverDTO;
import com.punit.cabBookingApplication.exception.DriverNotFoundException;
import com.punit.cabBookingApplication.model.Driver;
import com.punit.cabBookingApplication.repository.DriverRepository;
import com.punit.cabBookingApplication.util.helper.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverRepository driverRepository;


    @Override
    public String addDriver(DriverDTO driverDTO) {
        Driver driver = mapDtoToDriver(driverDTO);
        this.driverRepository.addDriver(driver);
        return driver.getDriverID();
    }

    @Override
    public Driver getDriverById(String id) {
        Driver driverFromDb = this.driverRepository.getDriver(id);
        if(driverFromDb == null) {
            throw new DriverNotFoundException("No Driver found with id: "+id);
        }
        return driverFromDb;
    }

    @Override
    public List<Driver> getAvailableDrivers(Location userLocation, int maxDistance) {
        return this.driverRepository.getDrivers().stream()
                .filter(Driver::getIsAvailable)
                .filter(driver -> calculateDistance(driver.getLocation(), userLocation) <= maxDistance)
                .collect(Collectors.toList());
    }

    private Driver mapDtoToDriver(DriverDTO driverDTO) {
        return new Driver(driverDTO.getName(), driverDTO.getGender(), driverDTO.getAge(), driverDTO.getVehicleInfo(), driverDTO.getLocation());
    }

    private int calculateDistance(Location location1, Location location2) {
        return (int) Math.sqrt(Math.pow(location1.getX() - location2.getX(), 2) + Math.pow(location1.getY() - location2.getY(), 2));
    }
}
