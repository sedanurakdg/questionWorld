    package com.example.questionworld.controller;


    import com.example.questionworld.model.Exam;
    import com.example.questionworld.model.Question;
    import com.example.questionworld.service.IExamService;
    import lombok.AllArgsConstructor;
    import org.springframework.http.MediaType;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;

    @RestController
    @RequestMapping(value = "/exams", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin("*")
    @AllArgsConstructor
    public class ExamController {

        private final IExamService examService;

        @PostMapping("/{userId}")
        public ResponseEntity<Exam> createExam(@PathVariable("userId") Integer userId,@RequestBody List<Question> questions) {
            return ResponseEntity.ok(examService.createExam(userId,questions));
        }

        @GetMapping("/{examId}")
        public ResponseEntity<Exam> getQuestiosnByLessonAndClassroom(@PathVariable("examId") Integer examId) {
            return ResponseEntity.ok(examService.getExam(examId));
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id) {
            examService.deleteExam(id);
            return ResponseEntity.ok("Exam Deleted. ID:" + id);
        }

    }
