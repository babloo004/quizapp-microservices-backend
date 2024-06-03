package com.example.QuizApp.MS.repository;

import com.example.QuizApp.MS.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionsRepo extends JpaRepository<Questions,Integer> {

    public List<Questions> findByCategory(String category);

    @Query(value="SELECT q.id FROM questions q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ",nativeQuery = true)
    public List<Integer> findByCategoryRand(String category,int numQ);
}
