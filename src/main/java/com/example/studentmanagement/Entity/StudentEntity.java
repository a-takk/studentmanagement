package com.example.studentmanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student_details")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "course")
    private String course;

    public StudentEntity(Long id, String fullname, String course, String email) {
        this.id = id;
        this.fullname = fullname;
        this.course = course;
        this.email = email;
    }

    public StudentEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullname='" + fullname + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}