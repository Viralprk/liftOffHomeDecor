package com.liftoffproject.premiumdecorsite.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {


    @PreAuthorize("permitAll()")
    @RequestMapping("/")
    public String welcome() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @PreAuthorize("permitAll()")
//    @RequestMapping("/home")
//    public String defaultWelcome() {
//        return "main";
//    }

    @GetMapping("/nindex")
    public String normaluser_home() {
        return "nindex";
    }

    @GetMapping("/aindex")
    public String Admin_home() {
        return "aindex";
    }


    @GetMapping("/goProduct")
    public String goProduct() {
        return "redirect:/product/viewProducts";
    }

}