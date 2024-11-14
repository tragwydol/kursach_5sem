// Файл: src/main/java/com/example/demo/repositories/CourseRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    // Пример метода для поиска курсов по компании
    List<Course> findByCompanyId(Integer companyId);
}
