package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Entity.UserEntity;
import com.example.studentmanagement.Service.ManagementServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student")
@SessionAttributes("userName")
public class StudentController {
    private final ManagementServiceImpl managementService;

    public StudentController(ManagementServiceImpl managementService) {
        this.managementService = managementService;
    }

    @RequestMapping("/list")
    public String listAllStudents(ModelMap modelMap) {
        managementService.listAllStudents(modelMap);
        return "StudentList";
    }


    @RequestMapping( "/add")
    public String addStudent(ModelMap modelMap, @ModelAttribute("studentEntity") StudentEntity studentEntity) {
        managementService.addStudent(modelMap, studentEntity);
        return "StudentAdd";
    }

    @RequestMapping("/update")
    public String updateStudent(ModelMap modelMap, @ModelAttribute("studentEntity") StudentEntity studentEntity) {
        managementService.updateStudent(modelMap, studentEntity);
        return "StudentUpdate";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam(value = "studentEntity") StudentEntity studentEntity) {
        managementService.deleteStudent(studentEntity);
        return "redirect:/student/list";
    }
}