package com.andytech.behive.controllers;

import com.andytech.behive.entities.user.User;
import com.andytech.behive.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

    @Autowired
    @InjectMocks
    UserController userController = new UserController();

    @Mock
    UserService userService;

    @Test
    void addUserTest() {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userService.addUser(any())).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.addUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteUserTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userService.deleteUser(any())).thenReturn(true);
        ResponseEntity<String> responseEntity = userController.deleteUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateUserTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userService.updateUser(any())).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.updateUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getUserTest() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userService.getUser(any())).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.getUser("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getUserTestFail() throws Exception {
        User user = new User();
        user.setName("test");
        user.setLastName("test");
        when(userService.getUser(any())).thenReturn(user);
        ResponseEntity<User> responseEntity = userController.getUser("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}