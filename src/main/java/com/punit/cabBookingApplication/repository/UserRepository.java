package com.punit.cabBookingApplication.repository;

import com.punit.cabBookingApplication.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUser(String userId) {
        UUID id = UUID.fromString(userId);
        for (User user : this.users) {
            UUID userUUID = UUID.fromString(user.getUserID());
            if (userUUID.equals(id)) {
                return user;
            }
        }
        return null;
    }
}
