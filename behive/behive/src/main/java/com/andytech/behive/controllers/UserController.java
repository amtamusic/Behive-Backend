package com.andytech.behive.controllers;

import com.andytech.behive.entities.user.User;
import com.andytech.behive.utils.LogMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);
    LogMessage message = new LogMessage("");

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        message.setMessage(String.format("Update User received: %s", id));
        log.info(message.getMessage());
        var user = new User();
        try {
            user.setId(Long.parseLong(id));
        } catch (Exception e) {
            user.setId(-1L);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<User> addUser(@RequestBody User user) {
        message.setMessage(String.format("Add User received: %s", user.toString()));
        log.info(message.getMessage());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        message.setMessage(String.format("Update User received: %s", user.toString()));
        log.info(message.getMessage());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<User> deleteUser(@RequestBody User user) {
        message.setMessage(String.format("Delete User received: %s", user.toString()));
        log.info(message.getMessage());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
