package com.example.CollegeAdmissionManagement.controller;

import com.example.CollegeAdmissionManagement.model.Course;
import com.example.CollegeAdmissionManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/course/list")
    public String listCourses(Model model) {
        model.addAttribute("courses", courseService.getAllCourse());
        return "courses";
    }

    @GetMapping("/course/add")
    public String showAddCourseForm() {
        return "add_course";
    }

    @PostMapping("/course/add")
    public String addCourse(@ModelAttribute Course course) {
        courseService.addCourse(course);
        return "redirect:/course/add";
    }

    @GetMapping("/course/update/{id}")
    public String showUpdateForm(@PathVariable Long id) {
        return "";
    }

    @PostMapping("/course/update")
    public String updateCourse() {
        return "";
    }

    @GetMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return "redirect:/course/list";
    }
}
