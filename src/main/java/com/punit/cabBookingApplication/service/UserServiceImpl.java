package com.punit.cabBookingApplication.service;

import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.exception.UserNotFoundException;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    public String addUser(UserDTO userDTO) {
        User user = mapDTOToUser(userDTO);
        this.userRepository.userDB().add(user);
        return user.getUserID();
    }

    @Override
    public List<User> getAllUsers() {
        return this.userRepository.userDB();
    }

    @Override
    public User getUserById(String userID) {
        User userFromDB = null;
        for(User user : this.userRepository.userDB()) {
            if(user.getUserID().equals(userID)) {
                userFromDB = user;
                break;
            }
        }
        if(userFromDB == null) {
            throw new UserNotFoundException("User not found: " + userID);
        }
        return userFromDB;
    }

    private User mapDTOToUser(UserDTO userDTO) {
        return new User(userDTO.getName(), userDTO.getGender(), userDTO.getAge());
    }
}
