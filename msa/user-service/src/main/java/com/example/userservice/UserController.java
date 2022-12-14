package com.example.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.domain.dto.UserCreateData;
import com.example.userservice.domain.dto.UserResponseData;

@RestController
public class UserController {

    private final UserService userService;
    
    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/users")
    public UserResponseData createUser(@RequestBody UserCreateData userCreateData) {
        return userService.save(userCreateData);
    }

    @GetMapping("/user/users/{userId}")
    public UserResponseData getUser(@PathVariable("userId") Long id) {
    	log.info("### UserController getUser------------------");
        return userService.getUserById(id);
    }
    
    @GetMapping("/user/users/resttemplate/{userId}")
    public UserResponseData getUserRestTemplate(@PathVariable("userId") Long id) {
    	log.info("### UserController getUserRestTemplate------------------");
        return userService.getUserByIdRestTemplate(id);
    }
    
    @GetMapping("/user/users/fegin/{userId}")
    public UserResponseData getUserFegin(@PathVariable("userId") Long id) {
    	log.info("### UserController getUserFegin------------------");
        return userService.getUserByIdFegin(id);
    }
    
}