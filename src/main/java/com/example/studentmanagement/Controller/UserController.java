package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.UserEntity;
import com.example.studentmanagement.Service.ManagementServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("userName")
public class UserController {
    private UserEntity userEntity;
    private final ManagementServiceImpl managementService;

    public UserController(ManagementServiceImpl managementService) {
        this.managementService = managementService;
    }

    @RequestMapping( "/signup")
    public String signUpUser(@ModelAttribute("userEntity") UserEntity userEntity) {
        managementService.saveUser(userEntity);
        return "SignUp";
    }

    @RequestMapping( "/admin-signup")
    public String signUpAdmin(@ModelAttribute("userEntity") UserEntity userEntity) {
        managementService.saveAdmin(userEntity);
        return "AdminSignUp";
    }

    @RequestMapping("/admin-dashboard")
    public String adminDashboard() {
        return "AdminDashboard";
    }

    @RequestMapping("/admin-workspace")
    public String adminWorkspace(ModelMap modelMap) {
        managementService.listAllUsers(modelMap);
        return "AdminList";
    }

    @GetMapping("/admin-workspace/delete")
    public String adminDelete(@RequestParam(value = "userEntity") UserEntity userEntity) {
        managementService.deleteUser(userEntity);
        return "redirect:/admin-workspace";
    }

    @RequestMapping("/login")
    public String login() {
        return "Login";
    }


    @RequestMapping("/logout")
    public String logout() {
        return "Logout";
    }

    @RequestMapping("/home")
    public String home() {
        return "Home";
    }
}

