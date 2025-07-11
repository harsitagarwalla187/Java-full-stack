package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/home")
    public String home(Model model) {
        String name = "Aman";
        model.addAttribute("name", name);
        return "home";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }
}
