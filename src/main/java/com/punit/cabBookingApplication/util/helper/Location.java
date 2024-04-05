package com.punit.cabBookingApplication.util.helper;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
