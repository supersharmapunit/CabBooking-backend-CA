package com.punit.cabBookingApplication.model;

import com.punit.cabBookingApplication.util.helper.Gender;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
public class User{
	private Gender gender;
	private String name;
	private String userID;
	private int age;

	public User(String name, Gender gender, int age) {
		this.userID = UUID.randomUUID().toString();
		this.age = age;
		this.gender = gender;
		this.name = name;
	}
}