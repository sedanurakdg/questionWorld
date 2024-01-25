package com.example.questionworld.controller;


import com.example.questionworld.dto.OpUserP;
import com.example.questionworld.dto.QuestionP;
import com.example.questionworld.model.LessonEnum;
import com.example.questionworld.model.OpUser;
import com.example.questionworld.model.Question;
import com.example.questionworld.service.IQuestionService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping(value = "/questions", produces = MediaType.APPLICATION_JSON_VALUE)
@EnableAutoConfiguration
@CrossOrigin("*")
@Log4j2
@AllArgsConstructor
public class OuestionController {
    private final IQuestionService questionService;

    @PostMapping
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionP questionP) {
        return ResponseEntity.ok(questionService.createQuestion(questionP));
    }

    @GetMapping
    public ResponseEntity<List<Question>> getQuestiosnByLessonAndClassroom(@QueryParam("lesson") LessonEnum lesson,
                                                                           @QueryParam("classroom") String classroom) {
        return ResponseEntity.ok(questionService.getAllQuestion(lesson, classroom));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> editQuestion(@PathVariable("id") Integer id, @RequestBody QuestionP questionP) {
        return ResponseEntity.ok(questionService.editQuestion(id,questionP));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") Integer id) {
        questionService.deleteQuestion(id);
        return ResponseEntity.ok("User Deleted. ID:" + id);
    }


}
