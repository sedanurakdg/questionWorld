package com.example.questionworld.service;

import com.example.questionworld.model.Exam;
import com.example.questionworld.model.Question;

import java.util.List;

public interface IExamService {
    Exam createExam(Integer userId, List<Question> question);

    Exam getExam(Integer examId);

    void deleteExam(Integer id);
}
