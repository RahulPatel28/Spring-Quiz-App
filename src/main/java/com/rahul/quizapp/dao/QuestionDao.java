package com.rahul.quizapp.dao;

import com.rahul.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao  extends JpaRepository<Questions , Integer> {

    List<Questions> findByCategory(String category);
   @Query(value = "SELECT * FROM Questions q WHERE q.category=:category ORDER BY Random() LIMIT :numQ " , nativeQuery = true)
    List<Questions> findRandomQuestionsByCategory(String category, int numQ);
}
