package com.punit.cabBookingApplication.exception;

public class NoRidesAvailableException extends RuntimeException{
    public NoRidesAvailableException(String message) {
        super(message);
    }
}
