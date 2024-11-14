// Файл: src/main/java/com/example/demo/repositories/UserAnswerRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
    // Пример метода для получения ответов пользователя по записи на курс
    List<UserAnswer> findByEnrollmentId(Integer enrollmentId);
}
