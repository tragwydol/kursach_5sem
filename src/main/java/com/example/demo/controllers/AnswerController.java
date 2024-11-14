// Файл: src/main/java/com/example/demo/controllers/AnswerController.java
package com.example.demo.controllers;

import com.example.demo.entities.Answer;
import com.example.demo.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entities.Question;
import com.example.demo.services.QuestionService;
import java.util.List;

@Controller
@RequestMapping("/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String listAnswers(Model model) {
        List<Answer> answers = answerService.findAll();
        model.addAttribute("answers", answers);
        return "answers"; // имя HTML-шаблона для списка ответов
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("answer", new Answer());
        return "answer-form"; // имя HTML-шаблона для создания ответа
    }

    @PostMapping
    public String createAnswer(@ModelAttribute Answer answer) {
        answerService.saveAnswer(answer);
        return "redirect:/answers";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Answer answer = answerService.findById(id).orElseThrow(() -> new RuntimeException("Answer not found"));
        model.addAttribute("answer", answer);

        // Получить все доступные вопросы
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);

        return "answer-form"; // имя HTML-шаблона для редактирования ответа
    }


    @PostMapping("/{id}")
    public String updateAnswer(@PathVariable Integer id,
                               @ModelAttribute Answer answer,
                               @RequestParam("question.id") Integer questionId) {
        Question question = questionService.findById(questionId);
        answer.setQuestion(question); // Установите вопрос в ответ
        answerService.updateAnswer(id, answer);
        return "redirect:/answers";
    }


    @PostMapping("/{id}/delete")
    public String deleteAnswer(@PathVariable Integer id) {
        answerService.deleteAnswer(id);
        return "redirect:/answers";
    }

    @GetMapping("/{id}")
    public String viewAnswer(@PathVariable Integer id, Model model) {
        Answer answer = answerService.findById(id).orElse(null);
        model.addAttribute("answer", answer);
        return "answer-detail"; // имя HTML-шаблона для просмотра ответа
    }
}
