// Файл: src/main/java/com/example/demo/controllers/EnrollmentController.java
package com.example.demo.controllers;

import com.example.demo.entities.Enrollment;
import com.example.demo.services.EnrollmentService;
import com.example.demo.services.CourseService;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enrollments")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    // Метод для отображения списка записей
    @GetMapping
    public String listEnrollments(Model model) {
        List<Enrollment> enrollments = enrollmentService.findAll();
        model.addAttribute("enrollments", enrollments);
        return "enrollment-list"; // имя HTML-шаблона для отображения списка записей
    }

    // Метод для отображения формы редактирования записи
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Enrollment enrollment = enrollmentService.findById(id);
        model.addAttribute("enrollment", enrollment);
        model.addAttribute("users", userService.findAll()); // Добавляем список пользователей
        model.addAttribute("courses", courseService.findAll()); // Добавляем список курсов
        return "enrollment-form"; // имя HTML-шаблона для редактирования записи
    }

    // Метод для сохранения записи
    @PostMapping("/save")
    public String saveEnrollment(@ModelAttribute Enrollment enrollment) {
        enrollmentService.saveEnrollment(enrollment);
        return "redirect:/enrollments"; // редирект на страницу со списком записей
    }

    // Метод для отображения формы добавления новой записи
    @GetMapping("/new")
    public String showNewForm(Model model) {
        model.addAttribute("enrollment", new Enrollment());
        model.addAttribute("users", userService.findAll()); // Добавляем список пользователей
        model.addAttribute("courses", courseService.findAll()); // Добавляем список курсов
        return "enrollment-form"; // имя HTML-шаблона для создания новой записи
    }
}
