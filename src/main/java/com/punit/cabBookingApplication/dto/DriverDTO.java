package com.punit.cabBookingApplication.dto;

import com.punit.cabBookingApplication.util.helper.Gender;
import com.punit.cabBookingApplication.util.helper.Location;
import com.punit.cabBookingApplication.util.helper.VehicleInfo;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class DriverDTO {
    private String name;
    private Gender gender;
    private int age;
    private VehicleInfo vehicleInfo;
    private Location location;
}