package com.example.CollegeAdmissionManagement.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String status;
    private int marks;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
