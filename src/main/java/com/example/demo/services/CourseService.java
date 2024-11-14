// Файл: src/main/java/com/example/demo/services/CourseService.java
package com.example.demo.services;

import com.example.demo.entities.Course;
import com.example.demo.repositories.CourseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    // Метод для получения всех курсов
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    // Метод для поиска курса по ID
    public Course findById(Integer id) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        return optionalCourse.orElse(null); // Вернет null, если курс не найден
    }
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Integer id, Course updatedCourse) {
        updatedCourse.setId(id);
        return courseRepository.save(updatedCourse);
    }

    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }
}
