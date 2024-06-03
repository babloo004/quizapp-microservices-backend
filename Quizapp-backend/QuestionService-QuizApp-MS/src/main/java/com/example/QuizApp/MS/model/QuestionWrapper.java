package com.example.QuizApp.MS.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private int id;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
}
