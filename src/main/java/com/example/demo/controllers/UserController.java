package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        if (users.isEmpty()) {
            model.addAttribute("error", "No users found.");
            return "no-user"; // Шаблон, отображаемый при отсутствии пользователей
        }
        model.addAttribute("users", users);
        return "users"; // Имя HTML-шаблона для списка пользователей
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form"; // Имя HTML-шаблона для создания пользователя
    }

    @PostMapping
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("error", "User not found.");
            return "error"; // Имя HTML-шаблона для отображения ошибки
        }
        model.addAttribute("user", user);
        return "user-form"; // Имя HTML-шаблона для редактирования пользователя
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Integer id, @ModelAttribute User user) {
        user.setId(id); // Устанавливаем ID для обновления
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("error", "User not found.");
            return "error"; // Имя HTML-шаблона для отображения ошибки
        }
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String viewUser(@PathVariable Integer id, Model model) {
        User user = userService.findById(id);
        if (user == null) {
            model.addAttribute("error", "User not found.");
            return "error"; // Имя HTML-шаблона для отображения ошибки
        }
        model.addAttribute("user", user);
        return "user-detail"; // Имя HTML-шаблона для просмотра пользователя
    }
}








