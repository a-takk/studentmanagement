package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.User;
import com.example.studentmanagement.Repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

