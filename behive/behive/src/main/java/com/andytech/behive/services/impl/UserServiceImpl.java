package com.andytech.behive.services.impl;

import com.andytech.behive.entities.user.User;
import com.andytech.behive.repositories.UserRepo;
import com.andytech.behive.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User getUser(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public boolean deleteUser(User user) {
        userRepo.delete(user);
        return true;
    }
}
