// Файл: src/main/java/com/example/demo/controllers/MainController.java
package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showHomePage(@AuthenticationPrincipal User user, Model model) {
        // Добавляем пользователя в модель
        model.addAttribute("user", user);
        return "index";
    }
}
