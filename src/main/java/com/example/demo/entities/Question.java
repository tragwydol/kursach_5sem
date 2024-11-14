// Файл: src/main/java/com/example/demo/entities/Question.java
package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(nullable = false)
    private String questionText;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    // Геттеры
    public Integer getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public String getQuestionText() {
        return questionText;
    }

    // Сеттеры
    public void setId(Integer id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
