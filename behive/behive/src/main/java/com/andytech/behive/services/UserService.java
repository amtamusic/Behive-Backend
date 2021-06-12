package com.andytech.behive.services;

import com.andytech.behive.entities.user.User;

public interface UserService {

    User getUser(String id);

    User addUser(User user);

    User updateUser(User user);

    boolean deleteUser(User user);
}
