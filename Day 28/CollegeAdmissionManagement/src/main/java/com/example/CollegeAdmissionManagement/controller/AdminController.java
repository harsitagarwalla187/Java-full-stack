package com.example.CollegeAdmissionManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/admin/dashboard")
    public String showDashboard() {
        return "admin_dashboard";
    }
}
