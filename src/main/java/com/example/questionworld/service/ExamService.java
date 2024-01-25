    package com.example.questionworld.service;


    import com.example.questionworld.model.Exam;
    import com.example.questionworld.model.OpUser;
    import com.example.questionworld.model.Question;
    import com.example.questionworld.repository.ExamRepository;
    import com.example.questionworld.repository.OpUserRepository;
    import lombok.AllArgsConstructor;
    import org.springframework.stereotype.Service;

    import javax.ws.rs.NotFoundException;
    import java.util.List;

    @Service
    @AllArgsConstructor
    public class ExamService implements IExamService {
        private final ExamRepository examRepository;
        private final OpUserRepository opUserRepository;

        @Override
        public Exam createExam(Integer userId, List<Question> question) {
            Exam exam = new Exam();
            OpUser opUser = opUserRepository.findOpUserById(userId);
            exam.setQuestions(question);
            exam.setOpUser(opUser);
            return examRepository.save(exam);
        }

        @Override
        public Exam getExam(Integer examId) {
            return examRepository.findById(examId).orElseThrow(NotFoundException::new);
        }

        @Override
        public void deleteExam(Integer id) {
            examRepository.deleteById(id);

        }
    }
