package com.example.SpringBootSample.controller;

import com.example.SpringBootSample.application.service.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequestMapping("/user")
public class SignupController {
    @Autowired
    private UserApplicationService userApplicationService;

    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale) {
        var genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup() {
        return "redirect:/login";
    }
}
