package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.User;
import com.example.studentmanagement.Repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/signup")
    public String signUp(@ModelAttribute("user") User user) {
        user.setId(0L);
        userRepository.save(user);
        return "SignUp";
    }

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "Logout";
    }
}

