package com.andytech.behive;

import com.andytech.behive.controllers.TestController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BehiveApplicationTests {

    @Autowired
    TestController testController;

    @Test
    void contextLoads() {
        assertThat(testController).isNotNull();
    }

}
