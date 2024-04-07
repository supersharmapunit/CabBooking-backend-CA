package com.punit.cabBookingApplication;

import com.punit.cabBookingApplication.dto.DriverDTO;
import com.punit.cabBookingApplication.dto.FindRideRequestDTO;
import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.model.Ride;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.service.DriverService;
import com.punit.cabBookingApplication.service.RideService;
import com.punit.cabBookingApplication.service.UserService;
import com.punit.cabBookingApplication.util.helper.Gender;
import com.punit.cabBookingApplication.util.helper.Location;
import com.punit.cabBookingApplication.util.helper.RideStatus;
import com.punit.cabBookingApplication.util.helper.VehicleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class CabBookingApplicationTests {
	@Autowired
	private UserService userService;
	@Autowired
	private DriverService driverService;
	@Autowired
	private RideService rideService;

	@Test
	void testUserOnBoarding() {
		UserDTO user1 = new UserDTO("John Doe", Gender.Male, 25);
		UserDTO user2 = new UserDTO("Jane Doe", Gender.Female, 22);
		UserDTO user3 = new UserDTO("Bob Smith", Gender.Male, 21);

		this.userService.addUser(user1);
		this.userService.addUser(user2);
		this.userService.addUser(user3);

		assertEquals("John Doe", this.userService.getAllUsers().get(0).getName(), "User name should be John Doe");
		assertEquals("Jane Doe", this.userService.getAllUsers().get(1).getName());
		assertEquals("Bob Smith", this.userService.getAllUsers().get(2).getName());
	}

	@Test
	void testDriverOnBoarding() {
		DriverDTO driver1 = new DriverDTO("John Doe", Gender.Male, 25, new VehicleInfo("Car", "ABC123"), new Location(0, 10));
		DriverDTO driver2 = new DriverDTO("Jane Doe", Gender.Female, 22, new VehicleInfo("Car", "DEF456"), new Location(15, 5));
		DriverDTO driver3 = new DriverDTO("Bob Smith", Gender.Male, 21, new VehicleInfo("Car", "GHI789"), new Location(20, 20));

		this.driverService.addDriver(driver1);
		this.driverService.addDriver(driver2);
		this.driverService.addDriver(driver3);

		assertEquals("John Doe", this.driverService.getAllDrivers().get(0).getName());
		assertEquals("Jane Doe", this.driverService.getAllDrivers().get(1).getName());
		assertEquals("Bob Smith", this.driverService.getAllDrivers().get(2).getName());
	}

	@Test
	void testFindRide() {
		UserDTO userDto1 = new UserDTO("John Doe", Gender.Male, 25);
		UserDTO userDto2 = new UserDTO("Jane Doe", Gender.Female, 25);


		DriverDTO driver1 = new DriverDTO("John Doe", Gender.Male, 25, new VehicleInfo("Car", "ABC123"), new Location(0, 10));
		DriverDTO driver2 = new DriverDTO("Jane Doe", Gender.Female, 22, new VehicleInfo("Car", "DEF456"), new Location(15, 5));
		DriverDTO driver3 = new DriverDTO("Bob Smith", Gender.Male, 21, new VehicleInfo("Car", "GHI789"), new Location(20, 20));

		this.userService.addUser(userDto1);
		this.userService.addUser(userDto2);

		this.driverService.addDriver(driver1);
		this.driverService.addDriver(driver2);
		this.driverService.addDriver(driver3);

		User user1 = this.userService.getAllUsers().get(0);
		User user2 = this.userService.getAllUsers().get(1);
		FindRideRequestDTO request1 = new FindRideRequestDTO(user1.getUserID(), new Location(0, 0), new Location(20, 20));
		try {
			List<Ride> availableRides = this.rideService.findRides(request1);
		} catch (Exception e) {
			assertEquals("No rides available", e.getMessage());
		}

		FindRideRequestDTO request2 = new FindRideRequestDTO(user2.getUserID(), new Location(10, 11), new Location(20, 20));
		try {
			List<Ride> availableRides = this.rideService.findRides(request2);
			assertEquals(1, availableRides.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testChooseRide() {
		UserDTO userDto = new UserDTO("Jane Doe", Gender.Female, 25);

		DriverDTO driver1 = new DriverDTO("John Doe", Gender.Male, 25, new VehicleInfo("Car", "ABC123"), new Location(0, 10));
		DriverDTO driver2 = new DriverDTO("Jane Doe", Gender.Female, 22, new VehicleInfo("Car", "DEF456"), new Location(15, 5));
		DriverDTO driver3 = new DriverDTO("Bob Smith", Gender.Male, 21, new VehicleInfo("Car", "GHI789"), new Location(20, 20));

		this.userService.addUser(userDto);

		User user1 = this.userService.getAllUsers().get(0);

		FindRideRequestDTO request2 = new FindRideRequestDTO(user1.getUserID(), new Location(10, 11), new Location(20, 20));
		try {
			List<Ride> availableRides = this.rideService.findRides(request2);
			Ride chosenRide = this.rideService.chooseRide(user1.getUserID(), availableRides.get(0).getDriverId());

			assertEquals(UUID.fromString(user1.getUserID()), UUID.fromString(chosenRide.getUserId()));
			assertEquals(UUID.fromString(availableRides.get(0).getDriverId()), UUID.fromString(chosenRide.getDriverId()));
			assertEquals(RideStatus.CONFIRMED, chosenRide.getStatus());
			assertFalse(this.driverService.getDriverById(chosenRide.getDriverId()).getIsAvailable());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
