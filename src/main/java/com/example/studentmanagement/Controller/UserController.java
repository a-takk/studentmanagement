package com.example.student.Controller;

import com.example.student.Entity.User;
import com.example.student.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/signup")
    public String signUp(@ModelAttribute("users") User user) {
        user.setId(0L);
        userRepository.save(user);
        return "SignUp";
    }

    @GetMapping("/login")
    public String login() {
        return "Login";
    }
}

