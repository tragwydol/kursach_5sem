// Файл: src/main/java/com/example/demo/repositories/QuestionRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    // Пример метода для получения вопросов по курсу
    List<Question> findByCourseId(Integer courseId);
}
