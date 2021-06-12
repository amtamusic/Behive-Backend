package com.andytech.behive.services.impl;

import com.andytech.behive.entities.user.User;
import com.andytech.behive.repositories.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @Autowired
    @InjectMocks
    UserServiceImpl userService = new UserServiceImpl();

    @Mock
    UserRepo userRepo;

    @Test
    void addUserTest() {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userRepo.save(any())).thenReturn(user);
        User response = userService.addUser(user);
        assertThat(response).isNotNull();
    }

    @Test
    void deleteUserTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        assertThat(userService.deleteUser(user)).isTrue();
    }

    @Test
    void updateUserTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userRepo.save(any())).thenReturn(user);
        User responseEntity = userService.updateUser(user);
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getUserTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userRepo.findById(any())).thenReturn(Optional.of(user));
        User responseEntity = userService.getUser("1");
        assertThat(responseEntity).isNotNull();
    }

    @Test
    void getUserTestNotPresent() throws Exception {
        when(userRepo.findById(any())).thenReturn(Optional.empty());
        User responseEntity = userService.getUser("1");
        assertThat(responseEntity).isNull();
    }
}