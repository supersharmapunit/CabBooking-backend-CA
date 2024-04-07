package com.punit.cabBookingApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ResponseDTO {
    private Boolean success;
    private String message;
    private Object data;
    private String error;
}
