package com.lv.game.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserCtrl {
    @Autowired
    private final UserRepository userRepository;

    public UserCtrl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/api/v1/user")
    public User user(@RequestBody User name) {
        return userRepository.save(name);
    }
}
