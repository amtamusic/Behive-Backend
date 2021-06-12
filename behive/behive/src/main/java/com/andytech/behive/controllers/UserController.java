package com.andytech.behive.controllers;

import com.andytech.behive.entities.user.User;
import com.andytech.behive.services.UserService;
import com.andytech.behive.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    LogUtils logUtils;

    public UserController() {
        this.logUtils = new LogUtils();
        this.logUtils.setLoggerClass(this.getClass());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") String id) {
        logUtils.logString(String.format("Update User received: %s", id));
        var user = userService.getUser(id);
        logUtils.logObject("Returned user after lookup by id : %s", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<User> addUser(@RequestBody User user) {
        logUtils.logObject("Add User received: %s", user);
        user = userService.addUser(user);
        logUtils.logObject("Add User result: %s", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        logUtils.logObject("Update User received: %s", user);
        user = userService.updateUser(user);
        logUtils.logObject("Update User result: %s", user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestBody User user) {
        logUtils.logObject("Delete User received: %s", user);
        userService.deleteUser(user);
        logUtils.logString("User " + user.toString() + " deleted");
        return new ResponseEntity<>(logUtils.getLogMessage().getMessage(), HttpStatus.OK);
    }
}
