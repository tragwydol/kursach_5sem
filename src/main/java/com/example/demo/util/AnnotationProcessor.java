package com.example.demo.util;

import com.example.demo.annotations.LogExecution;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void processAnnotations(Object obj) {
        Class<?> clazz = obj.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(LogExecution.class)) {
                LogExecution logExecution = method.getAnnotation(LogExecution.class);
                System.out.println(logExecution.value() + " " + method.getName());

                // Выполняем метод и замеряем время выполнения
                try {
                    long startTime = System.currentTimeMillis();
                    method.setAccessible(true);
                    method.invoke(obj);
                    long endTime = System.currentTimeMillis();
                    System.out.println("Время выполнения: " + (endTime - startTime) + " ms");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
