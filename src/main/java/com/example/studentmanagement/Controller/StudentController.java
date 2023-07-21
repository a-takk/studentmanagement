package com.example.student.Controller;

import com.example.student.Entity.Student;
import com.example.student.Repository.StudentRepository;
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
    public String listAll(ModelMap modelMap) {
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
    @DeleteMapping("/delete")
    public String delete(Student student) {
        studentRepository.delete(student);
        return "redirect:/student/list";
    }
}