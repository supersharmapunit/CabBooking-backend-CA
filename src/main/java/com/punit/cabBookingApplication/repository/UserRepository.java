package com.punit.cabBookingApplication.repository;

import com.punit.cabBookingApplication.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public List<User> userDB() {
        return this.users;
    }
}
