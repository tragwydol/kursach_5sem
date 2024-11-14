package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration"; // имя HTML-шаблона для регистрации
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/auth/login"; // редирект на страницу входа
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // имя HTML-шаблона для входа
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password) {
        // Логика аутентификации
        return "redirect:/courses"; // редирект на страницу курсов после входа
    }

    @GetMapping("/logout")
    public String logout() {
        // Логика выхода
        return "redirect:/auth/login"; // редирект на страницу входа
    }
}
