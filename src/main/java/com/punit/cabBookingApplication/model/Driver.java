package com.punit.cabBookingApplication.model;

import com.punit.cabBookingApplication.util.helper.Gender;
import com.punit.cabBookingApplication.util.helper.Location;
import com.punit.cabBookingApplication.util.helper.VehicleInfo;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class Driver {
    private String driverID;
    private String name;
    private Gender gender;
    private int age;
    private VehicleInfo vehicleInfo;
    private Location location;

    public Driver(String name, Gender gender, int age, VehicleInfo vehicleInfo, Location location) {
        this.driverID = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicleInfo = vehicleInfo;
        this.location = location;
    }
}
