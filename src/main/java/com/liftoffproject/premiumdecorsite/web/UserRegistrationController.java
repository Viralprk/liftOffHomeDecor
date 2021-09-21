package com.liftoffproject.premiumdecorsite.web;

import com.liftoffproject.premiumdecorsite.model.Role;
import com.liftoffproject.premiumdecorsite.model.User;
import com.liftoffproject.premiumdecorsite.service.UserService;
import com.liftoffproject.premiumdecorsite.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") User registerUser) {
        List<Role> normalRole =  new ArrayList<>();
        normalRole.add(new Role("NORMAL_USER"));
        registerUser.setRoles(normalRole);
        userService.save(registerUser);
        return "redirect:/registration?success";
    }
}