// Файл: src/main/java/com/example/demo/repositories/CompanyRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    // Дополнительные методы, если нужно, можно добавить здесь
}
