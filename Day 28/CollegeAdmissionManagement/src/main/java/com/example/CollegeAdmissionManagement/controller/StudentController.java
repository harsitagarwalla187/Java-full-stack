package com.example.CollegeAdmissionManagement.controller;

import com.example.CollegeAdmissionManagement.model.Student;
import com.example.CollegeAdmissionManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/register")
    public String showRegistrationForm() {
        return "student_register";
    }

    @PostMapping("/students/register")
    public String registerStudent(@ModelAttribute Student student,
                                  @RequestParam("file") MultipartFile file) {
        studentService.saveStudent(student); // implement save logic
        return "redirect:/admission/status";
    }


    @GetMapping("/students/list")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudent());
        return "admission_status";
    }

    @PostMapping("/students/allot")
    public String allotSeats() {
        return "";
    }

    @GetMapping("/students/merit-list")
    public String showMeritList() {
        return "merit_list";
    }

    @PostMapping("/students/allot/{id}")
    public String allotIndividualSeat(@PathVariable Long id) {
        return "";
    }
}
