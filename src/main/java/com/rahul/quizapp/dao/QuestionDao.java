package com.rahul.quizapp.dao;

import com.rahul.quizapp.model.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao  extends JpaRepository<Questions , Integer> {

    List<Questions> findByCategory(String category);

}
