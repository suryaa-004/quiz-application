package com.java.QuizApplication.service;


import com.java.QuizApplication.entity.Question;
import com.java.QuizApplication.entity.QuestionWrapper;
import com.java.QuizApplication.entity.Quiz;
import com.java.QuizApplication.repository.QuestionRepository;
import com.java.QuizApplication.repository.QuizRepository;
import com.java.QuizApplication.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    Quiz quiz;
    public ResponseEntity<String> createQuiz(String category,int numQ,String title){
        List<Question> questions = questionRepository.findQuestionByCategory(category,numQ);

        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepository.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
      Optional<Quiz> quiz = quizRepository.findById(id);
      List<Question> questionFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionForUser = new ArrayList<>();

        for (Question q:  questionFromDB){
            QuestionWrapper questionWrapper = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionForUser.add(questionWrapper);
        }
        return  new ResponseEntity<>(questionForUser, HttpStatus.OK);
    }
    public ResponseEntity<Integer> calculateResult(Integer id,List<Response> responses){
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right =0;
        int i =0;
        for (Response response: responses) {
            if (response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }
        return new ResponseEntity<>(right,HttpStatus.OK);
    }
}
