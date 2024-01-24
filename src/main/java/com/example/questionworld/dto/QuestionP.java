package com.example.questionworld.dto;

import com.example.questionworld.model.LessonEnum;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class QuestionP {
    private String question;
    private String answer;
    private String classRoom;
    @Enumerated(EnumType.STRING)
    private LessonEnum lesson;
}
