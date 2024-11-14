// Файл: src/test/java/com/example/demo/service/AnswerServiceTest.java
package com.example.demo.service;

import com.example.demo.entities.Answer;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.services.AnswerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AnswerServiceTest {

    @Mock
    private AnswerRepository answerRepository;

    @InjectMocks
    private AnswerService answerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Answer answer1 = new Answer();
        Answer answer2 = new Answer();
        when(answerRepository.findAll()).thenReturn(Arrays.asList(answer1, answer2));

        List<Answer> answers = answerService.findAll();
        assertEquals(2, answers.size());
        verify(answerRepository, times(1)).findAll();
    }

    @Test
    void saveAnswer() {
        Answer answer = new Answer();
        when(answerRepository.save(answer)).thenReturn(answer);

        Answer savedAnswer = answerService.saveAnswer(answer);
        assertNotNull(savedAnswer);
        verify(answerRepository, times(1)).save(answer);
    }

    @Test
    void findById() {
        Answer answer = new Answer();
        when(answerRepository.findById(1)).thenReturn(Optional.of(answer));

        Optional<Answer> foundAnswer = answerService.findById(1);
        assertTrue(foundAnswer.isPresent());
        verify(answerRepository, times(1)).findById(1);
    }

    @Test
    void updateAnswer() {
        Answer answer = new Answer();
        answer.setId(1);
        when(answerRepository.save(answer)).thenReturn(answer);

        Answer updatedAnswer = answerService.updateAnswer(1, answer);
        assertEquals(1, updatedAnswer.getId());
        verify(answerRepository, times(1)).save(answer);
    }

    @Test
    void deleteAnswer() {
        answerService.deleteAnswer(1);
        verify(answerRepository, times(1)).deleteById(1);
    }

    @Test
    void findAnswersByQuestionId() {
        Answer answer = new Answer();
        when(answerRepository.findByQuestionId(1)).thenReturn(Arrays.asList(answer));

        List<Answer> answers = answerService.findAnswersByQuestionId(1);
        assertEquals(1, answers.size());
        verify(answerRepository, times(1)).findByQuestionId(1);
    }
}
