package com.java.QuizApplication.repository;

import com.java.QuizApplication.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz,Integer>{

}
