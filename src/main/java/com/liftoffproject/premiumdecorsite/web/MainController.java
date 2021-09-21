package com.liftoffproject.premiumdecorsite.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize("permitAll()")
    @RequestMapping("/home")
    public String defaultWelcome() {
        return "main";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}