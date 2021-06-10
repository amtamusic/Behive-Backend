package com.andytech.behive.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class UtilsTest {
    @Test
    void logMessageTest()
    {
        LogMessage message=new LogMessage("");
        message.setMessage("test");
        assertThat(message.getMessage(),is("test"));
    }
}
