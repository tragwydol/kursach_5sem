// Файл: src/main/java/com/example/demo/services/AnswerService.java
package com.example.demo.services;

import com.example.demo.entities.Answer;
import com.example.demo.repositories.AnswerRepository;
import org.springframework.stereotype.Service;
import com.example.demo.annotations.LogExecution;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    // Получить все ответы
    @LogExecution("Executing findAll method:")
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    // Сохранить или обновить ответ
    @LogExecution("Executing findAll method:")
    public Answer saveAnswer(Answer answer) {
        return answerRepository.save(answer);
    }

    // Найти ответ по ID
    @LogExecution("Executing findAll method:")
    public Optional<Answer> findById(Integer id) {
        return answerRepository.findById(id);
    }

    @LogExecution("Executing findAll method:")
    public Answer updateAnswer(Integer id, Answer updatedAnswer) {
        updatedAnswer.setId(id); // Устанавливаем ID для обновляемого ответа
        return answerRepository.save(updatedAnswer);
    }

    @LogExecution("Executing findAll method:")
    public void deleteAnswer(Integer id) {
        answerRepository.deleteById(id);
    }

    @LogExecution("Executing findAll method:")
    public List<Answer> findAnswersByQuestionId(Integer questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}
