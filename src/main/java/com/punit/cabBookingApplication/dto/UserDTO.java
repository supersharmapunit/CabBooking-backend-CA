package com.punit.cabBookingApplication.dto;

import com.punit.cabBookingApplication.util.helper.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class UserDTO {
    private String name;
    private Gender gender;
    private int age;
}