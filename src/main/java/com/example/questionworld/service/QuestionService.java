package com.example.questionworld.service;


import com.example.questionworld.dto.QuestionP;
import com.example.questionworld.model.Question;
import com.example.questionworld.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.List;

@AllArgsConstructor
@Service
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Question createQuestion(QuestionP questionP) {
        Question question = new Question();
        question.setQuestion(questionP.getQuestion());
        question.setAnswer(questionP.getAnswer());
        question.setLesson(questionP.getLesson());
        question.setClassRoom(questionP.getClassRoom());
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAllQuestion(String lesson, String classroom) {
        return questionRepository.findByLessonAndClassRoom(lesson, classroom);
    }

    @Override
    public Question editQuestion(Integer id, QuestionP questionP) {
        Question question = questionRepository.findById(id).orElseThrow(NotFoundException::new);
        question.setQuestion(questionP.getQuestion());
        question.setAnswer(questionP.getAnswer());
        question.setLesson(questionP.getLesson());
        question.setClassRoom(questionP.getClassRoom());
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Integer id) {
        questionRepository.deleteById(id);
    }

}
