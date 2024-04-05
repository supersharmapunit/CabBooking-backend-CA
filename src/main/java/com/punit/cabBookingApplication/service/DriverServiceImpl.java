package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.DriverDTO;
import com.punit.cabBookingApplication.exception.DriverNotFoundException;
import com.punit.cabBookingApplication.model.Driver;
import com.punit.cabBookingApplication.repository.DriverRepository;
import com.punit.cabBookingApplication.util.helper.Location;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {
    private DriverRepository driverRepository;

    public DriverServiceImpl() {
        this.driverRepository = new DriverRepository();
    }


    @Override
    public String addDriver(DriverDTO driverDTO) {
        Driver driver = mapDtoToDriver(driverDTO);
        this.driverRepository.driverDB().add(driver);
        return driver.getDriverID();
    }

    @Override
    public Driver getDriverById(String id) {
        Driver driverFromDb = null;
        for(Driver driver : this.driverRepository.driverDB()) {
            if(driver.getDriverID().equals(id)) {
                driverFromDb = driver;
                break;
            }
        }
        if(driverFromDb == null) {
            throw new DriverNotFoundException("No Driver found with id: "+id);
        }
        return driverFromDb;
    }

    @Override
    public List<Driver> getAvailableDrivers(Location userLocation, int maxDistance) {
        return this.driverRepository.driverDB().stream()
                .filter(Driver::getIsAvailable)
                .filter(driver -> calculateDistance(driver.getLocation(), userLocation) <= maxDistance)
                .collect(Collectors.toList());
    }

    private Driver mapDtoToDriver(DriverDTO driverDTO) {
        return new Driver(driverDTO.getName(), driverDTO.getGender(), driverDTO.getAge(), driverDTO.getVehicleInfo(), driverDTO.getLocation());
    }

    private int calculateDistance(Location location1, Location location2) {
        int deltaX = location2.getX() - location1.getX();
        int deltaY = location2.getY() - location1.getY();

        return (int)Math.floor(Math.sqrt((deltaX*deltaX) + (deltaY * deltaY)));
    }
}
