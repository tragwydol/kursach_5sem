// Файл: src/main/java/com/example/demo/repositories/AnswerRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    List<Answer> findByQuestionId(Integer questionId);
}
