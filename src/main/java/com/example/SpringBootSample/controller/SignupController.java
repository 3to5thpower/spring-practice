package com.example.SpringBootSample.controller;

import com.example.SpringBootSample.application.service.UserApplicationService;
import com.example.SpringBootSample.form.SignupForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class SignupController {
    final private UserApplicationService userApplicationService;

    @GetMapping("/signup")
    public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
        var genderMap = userApplicationService.getGenderMap(locale);
        model.addAttribute("genderMap", genderMap);
        return "user/signup";
    }

    @PostMapping("/signup")
    public String postSignup(Model model, Locale locale, @ModelAttribute SignupForm form, BindingResult bindingResult) {
        // validation
        if (bindingResult.hasErrors()) {
            return getSignup(model, locale, form);
        }

        log.info(form.toString());
        return "redirect:/login";
    }
}
