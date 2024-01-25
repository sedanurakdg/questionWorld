package com.example.questionworld.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(targetEntity = Question.class, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "exam_question",
            joinColumns = {@JoinColumn(name = "exam_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "question_id", nullable = false, updatable = false)})
    private List<Question> questions;
    @ManyToOne(fetch = FetchType.LAZY)
    private OpUser opUser;
}
