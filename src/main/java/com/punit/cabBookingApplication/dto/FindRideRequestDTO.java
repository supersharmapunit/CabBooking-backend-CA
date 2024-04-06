package com.punit.cabBookingApplication.dto;

import com.punit.cabBookingApplication.util.helper.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class FindRideRequestDTO {
    private String userId;
    private Location source;
    private Location destination;
}
