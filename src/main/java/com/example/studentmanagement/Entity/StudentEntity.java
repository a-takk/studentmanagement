package com.example.studentmanagement.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_details")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "full_name")
    private String fullname;
    @Column(name = "course")
    private String course;

}