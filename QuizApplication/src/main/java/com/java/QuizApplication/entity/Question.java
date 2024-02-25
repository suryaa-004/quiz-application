package com.java.QuizApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "question_title")
    private String questionTitle;
    @Column(name = "option1")
    private  String option1;
    @Column(name = "option2")
    private  String option2;
    @Column(name = "option3")
    private  String option3;
    @Column(name = "option4")
    private  String option4;
    @Column(name = "right_answer")
    private  String rightAnswer;
    @Column(name = "difficulty_level")
    private  String difficultyLevel;
    @Column(name = "category")
    private String category;
}
