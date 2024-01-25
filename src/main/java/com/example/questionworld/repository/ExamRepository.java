    package com.example.questionworld.repository;

    import com.example.questionworld.model.Exam;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface ExamRepository extends JpaRepository<Exam,Integer> {
    }
