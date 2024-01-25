package com.example.questionworld.repository;

import com.example.questionworld.model.LessonEnum;
import com.example.questionworld.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByLessonAndClassRoom(LessonEnum lesson, String classRoom);
}
