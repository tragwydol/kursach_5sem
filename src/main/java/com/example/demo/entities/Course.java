// Файл: src/main/java/com/example/demo/entities/Course.java
package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String theoreticalContent;

    @Column(nullable = false)
    private int passingScore;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;

    @OneToMany(mappedBy = "course")
    private List<Question> questions;

    // Геттеры
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTheoreticalContent() {
        return theoreticalContent;
    }

    public int getPassingScore() {
        return passingScore;
    }

    public Company getCompany() {
        return company;
    }

    // Сеттеры
    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTheoreticalContent(String theoreticalContent) {
        this.theoreticalContent = theoreticalContent;
    }

    public void setPassingScore(int passingScore) {
        this.passingScore = passingScore;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
