package com.example.practica.controller;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.practica.model.User;

@Controller
public class UserController {
    //Lista para almacenar usuarios
    private List<User> listUsers = new ArrayList<User>();

    @GetMapping("/formUser")
    public String userForm(Model model){
        model.addAttribute("message", "Lista de Usuarios");
        model.addAttribute("user", new User());
        model.addAttribute("users", listUsers);
        return "users/create";
    } 

    @PostMapping("/createUser")
    public String userCreate(@Valid @ModelAttribute User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            model.addAttribute("users", listUsers); // Mantener la lista en la vista
            return "users/create"; // Volver al formulario con los errores
        }
        //agregar usuario a la lista
        listUsers.add(user); // Agregar usuario si no hay errores
        return "redirect:/formUser"; // Redirigir para limpiar el formulario
    }

    @GetMapping("/showUsers")
    public String userShow(Model model){
        model.addAttribute("users", listUsers);
        return "users/list";
    }
}
