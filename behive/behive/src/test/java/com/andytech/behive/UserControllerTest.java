package com.andytech.behive;

import com.andytech.behive.controllers.UserController;
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
    UserController employeeController;

    @Test
    void addUserTest() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        User user = new User();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<User> responseEntity = employeeController.addUser(user);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }
}