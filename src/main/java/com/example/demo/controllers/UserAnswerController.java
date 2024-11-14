package com.example.demo.controllers;

import com.example.demo.entities.UserAnswer;
import com.example.demo.services.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user-answers")
public class UserAnswerController {

    @Autowired
    private UserAnswerService userAnswerService;

    @GetMapping
    public String listUserAnswers(Model model) {
        List<UserAnswer> userAnswers = userAnswerService.findAll();
        model.addAttribute("userAnswers", userAnswers);
        return "user-answers"; // имя HTML-шаблона для списка ответов пользователей
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("userAnswer", new UserAnswer());
        return "user-answer-form"; // имя HTML-шаблона для создания ответа пользователя
    }

    @PostMapping
    public String createUserAnswer(@ModelAttribute UserAnswer userAnswer) {
        userAnswerService.saveUserAnswer(userAnswer);
        return "redirect:/user-answers";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        UserAnswer userAnswer = userAnswerService.findById(id);
        model.addAttribute("userAnswer", userAnswer);
        return "user-answer-form"; // имя HTML-шаблона для редактирования ответа пользователя
    }

    @PostMapping("/{id}")
    public String updateUserAnswer(@PathVariable Integer id, @ModelAttribute UserAnswer userAnswer) {
        userAnswer.setId(id); // устанавливаем ID для обновления
        userAnswerService.saveUserAnswer(userAnswer);
        return "redirect:/user-answers";
    }

    @PostMapping("/{id}/delete")
    public String deleteUserAnswer(@PathVariable Integer id) {
        userAnswerService.deleteUserAnswer(id);
        return "redirect:/user-answers";
    }

    @GetMapping("/{id}")
    public String viewUserAnswer(@PathVariable Integer id, Model model) {
        UserAnswer userAnswer = userAnswerService.findById(id);
        model.addAttribute("userAnswer", userAnswer);
        return "user-answer-detail"; // имя HTML-шаблона для просмотра ответа пользователя
    }
}
