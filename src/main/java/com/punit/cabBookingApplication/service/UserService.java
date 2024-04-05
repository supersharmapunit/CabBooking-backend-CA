package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public String addUser(UserDTO userDTO);
    public List<User> getAllUsers();
    public User getUserById(String userID);
}
