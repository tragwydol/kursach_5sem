// Файл: src/test/java/com/example/demo/controllers/AnswerControllerTest.java
package com.example.demo.controllers;

import com.example.demo.entities.Answer;
import com.example.demo.entities.Question;
import com.example.demo.services.AnswerService;
import com.example.demo.services.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AnswerControllerTest {

    private MockMvc mockMvc;

    @Mock
    private AnswerService answerService;

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private AnswerController answerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(answerController).build();
    }

    @Test
    void showCreateForm() throws Exception {
        mockMvc.perform(get("/answers/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("answer-form"))
                .andExpect(model().attributeExists("answer"));
    }

    @Test
    void createAnswer() throws Exception {
        mockMvc.perform(post("/answers")
                        .param("text", "Sample Answer"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/answers"));

        verify(answerService, times(1)).saveAnswer(any(Answer.class));
    }

    @Test
    void showEditForm() throws Exception {
        Answer answer = new Answer();
        answer.setId(1);
        when(answerService.findById(1)).thenReturn(Optional.of(answer));
        when(questionService.findAll()).thenReturn(Arrays.asList(new Question()));

        mockMvc.perform(get("/answers/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("answer-form"))
                .andExpect(model().attributeExists("answer"))
                .andExpect(model().attributeExists("questions"));

        verify(answerService, times(1)).findById(1);
        verify(questionService, times(1)).findAll();
    }

    @Test
    void updateAnswer() throws Exception {
        mockMvc.perform(post("/answers/1")
                        .param("question.id", "1")
                        .param("text", "Updated Answer"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/answers"));

        verify(answerService, times(1)).updateAnswer(eq(1), any(Answer.class));
    }

    @Test
    void deleteAnswer() throws Exception {
        mockMvc.perform(post("/answers/1/delete"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/answers"));

        verify(answerService, times(1)).deleteAnswer(1);
    }

    @Test
    void viewAnswer() throws Exception {
        Answer answer = new Answer();
        answer.setId(1);
        when(answerService.findById(1)).thenReturn(Optional.of(answer));

        mockMvc.perform(get("/answers/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("answer-detail"))
                .andExpect(model().attributeExists("answer"));

        verify(answerService, times(1)).findById(1);
    }
}
