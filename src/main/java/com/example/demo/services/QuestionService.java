// Файл: src/main/java/com/example/demo/services/QuestionService.java
package com.example.demo.services;

import com.example.demo.entities.Question;
import com.example.demo.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    // Метод для получения всех вопросов
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    // Метод для поиска вопроса по ID
    public Question findById(Integer id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
        return optionalQuestion.orElse(null); // Вернет null, если вопрос не найден
    }
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(Integer id) {
        return questionRepository.findById(id);
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question updateQuestion(Integer id, Question updatedQuestion) {
        updatedQuestion.setId(id);
        return questionRepository.save(updatedQuestion);
    }

    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }
}
