package com.example.studentmanagement.Service;

import com.example.studentmanagement.Entity.RoleEntity;
import com.example.studentmanagement.Entity.StudentEntity;
import com.example.studentmanagement.Entity.UserEntity;
import com.example.studentmanagement.Repository.StudentRepository;
import com.example.studentmanagement.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ManagementServiceImpl implements ManagementService {
    private final StudentRepository studentRepository;
    private final UserRepository userRepository;

    public ManagementServiceImpl(StudentRepository studentRepository, UserRepository userRepository) {
        this.studentRepository = studentRepository;
        this.userRepository = userRepository;
    }

    //students

    @Override
    public void listAllStudents(ModelMap modelMap) {
        List<StudentEntity> studentEntity = studentRepository.findAll();
        modelMap.put("studentEntity", studentEntity);
    }

    @Override
    public void addStudent(ModelMap modelMap, StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }

    @Override
    public void updateStudent(ModelMap modelMap, StudentEntity studentEntity) {
        studentRepository.save(studentEntity);
    }

    @Override
    public void deleteStudent(StudentEntity studentEntity) {
        studentRepository.delete(studentEntity);
    }

    //users and admins
    @Override
    public void listAllUsers(ModelMap modelMap) {
        List<UserEntity> userEntity = userRepository.findAll();
        modelMap.put("userEntity", userEntity);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setId(0L);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(RoleEntity.USER);
        userEntity.setRoles(roles);
        userRepository.save(userEntity);
    }

    @Override
    public void saveAdmin(UserEntity userEntity) {
        userEntity.setId(0L);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(RoleEntity.ADMIN);
        userEntity.setRoles(roles);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        userRepository.delete(userEntity);
    }
}
