package com.example.practica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

//import ch.qos.logback.core.model.Model;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "¡Bienvenido a mi aplicación con Spring Boot y Thymeleaf!");
        return "home";
    }

}
