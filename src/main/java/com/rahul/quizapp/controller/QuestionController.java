package com.rahul.quizapp.controller;

import com.rahul.quizapp.model.Questions;
import com.rahul.quizapp.model.Questions;
import com.rahul.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("questions")

public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<Questions> getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public List<Questions> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public String addQuestions(@RequestBody Questions questions){
       return questionService.addQuestion(questions);

    }

}
