package com.example.aquilae;

import com.example.aquilae.user.AdminController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontGiver {

    private static final Logger logger = LoggerFactory.getLogger(FrontGiver.class);

    @GetMapping("/hello")
    public String hello() {
        logger.info("hello called");
        return "index";
    }
    @GetMapping("/home")
    public String homepage() {
        logger.info("homepage called");
        return "home";
    }
    @GetMapping("/login")
    public String login() {
        logger.info("login page called");
        return "login";
    }
    @GetMapping("/register")
    public String register() {
        logger.info("registration page  called");
        return "register";
    }
    @GetMapping("/admin")
    public String adminPanel() {
        logger.info("admin panel called");
        return "admin";
    }

}
