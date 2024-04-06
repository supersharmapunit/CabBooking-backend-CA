package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.FindRideRequestDTO;
import com.punit.cabBookingApplication.exception.DriverNotFoundException;
import com.punit.cabBookingApplication.exception.NoRidesAvailableException;
import com.punit.cabBookingApplication.exception.UserNotFoundException;
import com.punit.cabBookingApplication.model.Driver;
import com.punit.cabBookingApplication.model.Ride;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.repository.RideRepository;
import com.punit.cabBookingApplication.util.helper.RideStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Service
public class RideServiceImpl implements  RideService{
    @Autowired
    private UserService userService;
    @Autowired
    private DriverService driverService;
    @Autowired
    private RideRepository rideRepository;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    @Override
    public List<Ride> findRides(FindRideRequestDTO findRideRequestDTO) {
        lock.readLock().lock();
        try {
            User user = this.userService.getUserById(findRideRequestDTO.getUserId());
            List<Driver> availableDrivers = this.driverService.getAvailableDrivers(findRideRequestDTO.getSource(), 5);
            if(availableDrivers.isEmpty()) {
                throw new NoRidesAvailableException("No rides available");
            }
            List<Ride> availableRides = new ArrayList<>();
            for(Driver driver: availableDrivers) {
                this.rideRepository.removeRideByUserIdAndDriverId(user.getUserID(), driver.getDriverID());
                Ride ride = new Ride(user.getUserID(),
                        driver.getDriverID(),
                        findRideRequestDTO.getSource(),
                        findRideRequestDTO.getDestination(),
                        RideStatus.REQUESTED);
                availableRides.add(ride);
                this.rideRepository.addRide(ride);
            }
            return availableRides;
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public Ride chooseRide(String userId, String driverId) {
        lock.writeLock().lock();
        try {
            User user = this.userService.getUserById(userId);
            if(user == null) {
                throw new UserNotFoundException("User not found");
            }
            Driver driver = this.driverService.getDriverById(driverId);
            if(driver == null) {
                throw new DriverNotFoundException("Driver not found");
            }
            Ride ride = this.rideRepository.getRideByDriverId(driverId);
            driver.setIsAvailable(false);
            ride.setStatus(RideStatus.CONFIRMED);
            this.rideRepository.removeRideByUserIdAndDriverId(userId, driverId);
            this.rideRepository.addRide(ride);
            return ride;
        } catch (Exception e) {
            if(e instanceof NoRidesAvailableException || e instanceof DriverNotFoundException || e instanceof UserNotFoundException) {
                throw e;
            } else {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public List<Ride> getRides() {
        return this.rideRepository.getRides().values().stream().toList();
    }
}
