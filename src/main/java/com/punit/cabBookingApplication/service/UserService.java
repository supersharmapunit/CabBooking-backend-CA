package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.ModelCreatedResponseDTO;
import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.model.User;

import java.util.List;

public interface UserService {
    public ModelCreatedResponseDTO addUser(UserDTO userDTO);
    public List<User> getAllUsers();
    public User getUserById(String userID);
}
