package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.model.User;
import com.punit.cabBookingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String addCustomer(@RequestBody UserDTO customer) {
        return this.userService.addUser(customer);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }
}
