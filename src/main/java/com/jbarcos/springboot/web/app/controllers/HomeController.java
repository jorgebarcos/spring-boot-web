package com.jbarcos.springboot.web.app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        /*return "redirect:/app/index";*/
        // Forward ejecuta RequestDispatcher.forward()
        return "forward:/app/index";
    }
}
