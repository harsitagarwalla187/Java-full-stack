package com.springmvc.controller;

import com.springmvc.controller.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {

    @RequestMapping("/form")
    public String form() {
        return "form";
    }

//    @RequestMapping(path = "/save", method = RequestMethod.POST)
//    public String saveForm(@RequestParam("email") String email, @RequestParam("password") String password) {
//        System.out.println(email + password);
//        return "home";
//    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String saveForm(@ModelAttribute User user) {
        System.out.println(user);
        return "home";
    }
}
