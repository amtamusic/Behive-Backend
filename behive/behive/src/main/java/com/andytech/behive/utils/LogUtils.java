package com.andytech.behive.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogUtils {
    Logger log;
    LogMessage message = new LogMessage("");

    public void setLoggerClass(Class<?> c) {
        this.log = LoggerFactory.getLogger(c);
    }

    public void logObject(String message, Object object) {
        this.message.setMessage(String.format(message, object.toString()));
        log.info(this.message.getMessage());
    }

    public void logString(String message) {
        this.message.setMessage(message);
    }

    public LogMessage getLogMessage() {
        return this.message;
    }
}
