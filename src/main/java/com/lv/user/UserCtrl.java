package com.lv.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.lv.api.Constants.API_URL;

@RestController
@RequestMapping(API_URL)
public class UserCtrl {
    @Autowired
    private final UserRepository userRepository;

    public UserCtrl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/user")
    public User user(@RequestBody User name) {
        return userRepository.save(name);
    }
}
