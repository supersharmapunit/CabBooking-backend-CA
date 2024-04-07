package com.punit.cabBookingApplication.controller;

import com.punit.cabBookingApplication.dto.ResponseDTO;
import com.punit.cabBookingApplication.dto.UserDTO;
import com.punit.cabBookingApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDTO> addCustomer(@RequestBody UserDTO customer) {
        try {
            return ResponseEntity.created(null).body(new ResponseDTO(true, "Customer added successfully",
                    this.userService.addUser(customer), null));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ResponseDTO(false, "Unable to add customer", null, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getAllUsers() {
        return ResponseEntity.ok(new ResponseDTO(true, "Customers fetched successfully", this.userService.getAllUsers(), null));
    }
}
