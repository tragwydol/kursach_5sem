// Файл: src/main/java/com/example/demo/repositories/CertificateRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
    // Пример метода для поиска сертификатов по пользователю
    List<Certificate> findByUserId(Integer userId);
}
