package com.punit.cabBookingApplication.util.helper;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VehicleInfo {
    private String carType;
    private String registrationNumber;

    public VehicleInfo(String carType, String registrationNumber) {
        this.carType = carType;
        this.registrationNumber = registrationNumber;
    }
}
