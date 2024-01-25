    package com.example.questionworld.service;

    import com.example.questionworld.dto.QuestionP;
    import com.example.questionworld.model.LessonEnum;
    import com.example.questionworld.model.OpUser;
    import com.example.questionworld.model.Question;

    import java.util.List;

    public interface IQuestionService {

        Question createQuestion(QuestionP questionP);

        List<Question> getAllQuestion(LessonEnum lesson, String classroom);

        Question editQuestion(Integer id,QuestionP questionP);
        void deleteQuestion(Integer id);
    }
