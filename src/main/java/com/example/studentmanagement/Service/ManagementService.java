package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Entity.UserEntity;
import org.springframework.boot.Banner;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

public interface ManagementService {
    //student methods to insert into the implementation
    void listAllStudents(ModelMap modelMap);
    void addStudent(ModelMap modelMap, StudentEntity students);
    void updateStudent(ModelMap modelMap, StudentEntity students);
    void deleteStudent(StudentEntity studentEntity);

    //user methods to insert into the implementation
    void listAllUsers(ModelMap modelMap);
    void saveUser(UserEntity userEntity);
    void saveAdmin(UserEntity userEntity);
    void deleteUser(UserEntity userEntity);
}
