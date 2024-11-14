package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://localhost:8080/login
@SpringBootApplication
public class MavenApplication {

	public static void main(String[] args) {
		System.out.println("Приложение запускается..."); // Вывод сообщения в консоль
		SpringApplication.run(MavenApplication.class, args);
		System.out.println("Приложение запущено успешно!"); // Сообщение после запуска
	}
}
