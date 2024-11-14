// Файл: src/main/java/com/example/demo/entities/UserAnswer.java
package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "UserAnswers")
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(nullable = false)
    private boolean selectedAnswer;

    // Геттеры
    public Integer getId() {
        return id;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer() {
        return answer;
    }

    public boolean isSelectedAnswer() {
        return selectedAnswer;
    }

    // Сеттеры
    public void setId(Integer id) {
        this.id = id;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setSelectedAnswer(boolean selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
