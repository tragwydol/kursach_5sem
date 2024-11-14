// Файл: src/main/java/com/example/demo/repositories/UserRepository.java
package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Например, метод для поиска пользователя по имени
    User findByUsername(String username);
}
