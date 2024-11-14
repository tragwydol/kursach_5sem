package com.example.demo.controllers;

import com.example.demo.entities.Question;
import com.example.demo.entities.Course;
import com.example.demo.services.QuestionService;
import com.example.demo.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CourseService courseService; // Внедрение зависимости CourseService

    @GetMapping
    public String listQuestions(Model model) {
        List<Question> questions = questionService.findAll();
        model.addAttribute("questions", questions);
        return "questions"; // имя HTML-шаблона для списка вопросов
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("question", new Question());

        List<Course> courses = courseService.findAll(); // Загрузить все доступные курсы
        model.addAttribute("courses", courses);

        return "question-form"; // имя HTML-шаблона для создания вопроса
    }

    @PostMapping
    public String createQuestion(@ModelAttribute Question question) {
        questionService.saveQuestion(question);
        return "redirect:/questions";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Question question = questionService.findById(id);
        model.addAttribute("question", question);

        List<Course> courses = courseService.findAll(); // Загрузить все доступные курсы
        model.addAttribute("courses", courses);

        return "question-form";
    }

    @PostMapping("/{id}")
    public String updateQuestion(@PathVariable Integer id, @ModelAttribute Question question, @RequestParam("course.id") Integer courseId) {
        question.setId(id);
        Course course = courseService.findById(courseId); // Получить курс по ID
        question.setCourse(course); // Установить курс в вопрос
        questionService.saveQuestion(question);
        return "redirect:/questions";
    }

    @PostMapping("/{id}/delete")
    public String deleteQuestion(@PathVariable Integer id) {
        questionService.deleteQuestion(id);
        return "redirect:/questions";
    }

    @GetMapping("/{id}")
    public String viewQuestion(@PathVariable Integer id, Model model) {
        Question question = questionService.findById(id);
        model.addAttribute("question", question);
        return "question-detail"; // имя HTML-шаблона для просмотра вопроса
    }
}
