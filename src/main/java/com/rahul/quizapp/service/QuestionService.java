package com.rahul.quizapp.service;

import com.rahul.quizapp.dao.QuestionDao;
import com.rahul.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public List<Questions> getAllQuestions() {

      return   questionDao.findAll();
    }

    public List<Questions> getQuestionsByCategory(String category) {
        String modifiedCategory = capitalizeFirstLetter(category);
        return questionDao.findByCategory(modifiedCategory); // java -> Java
    }
    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }


    public String addQuestion(Questions questions) {
        questionDao.save(questions);
        return "success";

    }
}
