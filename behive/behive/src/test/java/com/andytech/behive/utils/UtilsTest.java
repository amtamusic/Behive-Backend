package com.andytech.behive.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(MockitoJUnitRunner.class)
class UtilsTest {
    @Test
    void logMessageTest() {
        LogMessage message = new LogMessage("");
        message.setMessage("test");
        assertThat(message.getMessage(), is("test"));
    }
}
