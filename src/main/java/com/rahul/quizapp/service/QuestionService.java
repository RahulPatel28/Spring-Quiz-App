package com.rahul.quizapp.service;

import com.rahul.quizapp.dao.QuestionDao;
import com.rahul.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;
    public ResponseEntity<List<Questions>> getAllQuestions() {
      try {
          return  new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
      }catch (Exception e){
          e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST);
    }



    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category) {
       try{
           String modifiedCategory = capitalizeFirstLetter(category);
           return new ResponseEntity<>(questionDao.findByCategory(modifiedCategory), HttpStatus.OK);// java -> Java
       }catch (Exception e){
           e.printStackTrace();
       }
       return new ResponseEntity<>(new ArrayList<>() , HttpStatus.BAD_REQUEST);
    }



    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) return str;
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }


    public ResponseEntity<String> addQuestion(Questions questions) {
      try{
          questionDao.save(questions);
       return   new ResponseEntity<>(  "success" , HttpStatus.CREATED);
      }catch (Exception e){
          e.printStackTrace();
      }
      return new ResponseEntity<>("failed to add" , HttpStatus.BAD_REQUEST);

    }
}
