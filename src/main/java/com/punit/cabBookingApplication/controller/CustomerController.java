package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.service.UserService;
import com.punit.cabBookingApplication.service.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private UserService userService;
    public CustomerController() {
        this.userService = new UserServiceImpl();
    }

    @PostMapping
    public String addCustomer(@RequestBody UserDTO customer) {
        return this.userService.addUser(customer);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
