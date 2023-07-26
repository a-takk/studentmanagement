package com.example.studentmanagement.Controller;

import com.example.studentmanagement.Entity.Student;
import com.example.studentmanagement.Repository.StudentRepository;
import jakarta.validation.Valid;
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
        List<Student> students = studentRepository.findAll();
        modelMap.put("students", students);
        return "StudentList";
    }
    @RequestMapping( "/add")
    public String addStudent(ModelMap modelMap, Student students) {
        modelMap.put("students", students);
        studentRepository.save(students);
        return "AddStudent";
    }

    @RequestMapping("/update")
    public String updateStudent(Student student, ModelMap modelMap) {
        modelMap.put("students", student);
        studentRepository.save(student);
        return "UpdateStudent";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("student") Student student) {
        studentRepository.delete(student);
        return "redirect:/student/list";
    }
}