package com.java.QuizApplication.controller;

import com.java.QuizApplication.entity.Question;
import com.java.QuizApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getALlQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return  questionService.questionsByCategory(category);
    }

    @PostMapping("addQuestions")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestions(question);
    }
}
