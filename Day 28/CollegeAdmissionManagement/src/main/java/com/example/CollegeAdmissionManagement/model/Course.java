package com.example.CollegeAdmissionManagement.model;

import com.example.CollegeAdmissionManagement.repository.CourseRepository;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int seats;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Student> students;
}
