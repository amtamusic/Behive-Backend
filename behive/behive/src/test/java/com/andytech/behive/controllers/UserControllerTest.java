package com.andytech.behive.controllers;

import com.andytech.behive.entities.user.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class UserControllerTest {
    @InjectMocks
    UserController userController;

    @Test
    void addUserTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        User user = new User();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<User> responseEntity = userController.addUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void deleteUserTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        User user = new User();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<User> responseEntity = userController.deleteUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void updateUserTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        User user = new User();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<User> responseEntity = userController.updateUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getUserTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<User> responseEntity = userController.getUser("1");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void getUserTestFail() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<User> responseEntity = userController.getUser("a");
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}