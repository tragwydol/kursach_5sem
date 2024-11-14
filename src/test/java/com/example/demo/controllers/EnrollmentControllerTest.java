package com.example.demo.controllers;

import com.example.demo.entities.Enrollment;
import com.example.demo.services.EnrollmentService;
import com.example.demo.services.UserService;
import com.example.demo.services.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.Mockito.*;

class EnrollmentControllerTest {

    @Mock
    private EnrollmentService enrollmentService;

    @Mock
    private UserService userService;

    @Mock
    private CourseService courseService;

    @Mock
    private Model model;

    @InjectMocks
    private EnrollmentController enrollmentController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListEnrollments() {
        enrollmentController.listEnrollments(model);
        verify(enrollmentService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("enrollments"), any());
    }

    @Test
    void testShowEditForm() {
        Integer id = 1;
        when(enrollmentService.findById(id)).thenReturn(new Enrollment());
        enrollmentController.showEditForm(id, model);
        verify(enrollmentService, times(1)).findById(id);
        verify(model, times(1)).addAttribute(eq("enrollment"), any());
        verify(model, times(1)).addAttribute(eq("users"), any());
        verify(model, times(1)).addAttribute(eq("courses"), any());
    }
}
