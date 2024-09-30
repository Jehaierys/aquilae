package com.example.aquilae;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontGiver {
    @GetMapping("/hello")
    public String hello() {
        return "index";
    }
    @GetMapping("/home")
    public String homepage() {
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    @GetMapping("/admin")
    public String adminPanel() {
        return "admin";
    }

}
