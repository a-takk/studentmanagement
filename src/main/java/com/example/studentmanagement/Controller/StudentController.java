package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list")
    public String listAllStudents(ModelMap modelMap) {
        List<StudentEntity> studentEntities = studentRepository.findAll();
        modelMap.put("students", studentEntities);
        return "StudentList";
    }
    @RequestMapping( "/add")
    public String addStudent(ModelMap modelMap, StudentEntity students) {
        modelMap.put("students", students);
        studentRepository.save(students);
        return "AddStudent";
    }

    @RequestMapping("/update")
    public String updateStudent(StudentEntity studentEntity, ModelMap modelMap) {
        modelMap.put("students", studentEntity);
        studentRepository.save(studentEntity);
        return "UpdateStudent";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam(value = "studentEntity") StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
        return "redirect:/student/list";
    }
}