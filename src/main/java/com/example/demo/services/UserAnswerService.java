// Файл: src/main/java/com/example/demo/services/UserAnswerService.java
package com.example.demo.services;

import com.example.demo.entities.UserAnswer;
import com.example.demo.repositories.UserAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAnswerService {
    private final UserAnswerRepository userAnswerRepository;

    public void saveUserAnswer(UserAnswer userAnswer) {
        userAnswerRepository.save(userAnswer);
    }

    // Метод для получения всех ответов пользователей
    public List<UserAnswer> findAll() {
        return userAnswerRepository.findAll();
    }

    // Метод для поиска ответа пользователя по ID
    public UserAnswer findById(Integer id) {
        Optional<UserAnswer> optionalUserAnswer = userAnswerRepository.findById(id);
        return optionalUserAnswer.orElse(null); // Вернет null, если ответ не найден
    }
    public UserAnswerService(UserAnswerRepository userAnswerRepository) {
        this.userAnswerRepository = userAnswerRepository;
    }

    public List<UserAnswer> getAllUserAnswers() {
        return userAnswerRepository.findAll();
    }

    public Optional<UserAnswer> getUserAnswerById(Integer id) {
        return userAnswerRepository.findById(id);
    }

    public UserAnswer createUserAnswer(UserAnswer userAnswer) {
        return userAnswerRepository.save(userAnswer);
    }

    public UserAnswer updateUserAnswer(Integer id, UserAnswer updatedUserAnswer) {
        updatedUserAnswer.setId(id);
        return userAnswerRepository.save(updatedUserAnswer);
    }

    public void deleteUserAnswer(Integer id) {
        userAnswerRepository.deleteById(id);
    }
}
