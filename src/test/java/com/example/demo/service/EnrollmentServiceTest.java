package com.example.demo.service;

import com.example.demo.entities.Enrollment;
import com.example.demo.repositories.EnrollmentRepository;
import com.example.demo.services.EnrollmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Enrollment enrollment = new Enrollment();
        enrollment.setId(1);
        when(enrollmentRepository.findById(1)).thenReturn(Optional.of(enrollment));

        Enrollment found = enrollmentService.findById(1);
        assertEquals(1, found.getId());
        verify(enrollmentRepository, times(1)).findById(1);
    }

    @Test
    void testSaveEnrollment() {
        Enrollment enrollment = new Enrollment();
        enrollmentService.saveEnrollment(enrollment);
        verify(enrollmentRepository, times(1)).save(enrollment);
    }

    @Test
    void testFindAll() {
        enrollmentService.findAll();
        verify(enrollmentRepository, times(1)).findAll();
    }
}
