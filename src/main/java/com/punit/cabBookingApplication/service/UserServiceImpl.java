package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.ModelCreatedResponseDTO;
import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.exception.UserNotFoundException;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public ModelCreatedResponseDTO addUser(UserDTO userDTO) {
        User user = mapDTOToUser(userDTO);
        this.userRepository.addUser(user);
        return new ModelCreatedResponseDTO(user.getUserID());
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public User getUserById(String userID) {
        User userFromDB = this.userRepository.getUser(userID);
        if(userFromDB == null) {
            throw new UserNotFoundException("User not found: " + userID);
        }
        return userFromDB;
    }

    private User mapDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getGender(), userDTO.getAge());
    }
}
