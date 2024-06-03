package com.example.QuizApp.MS.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="questions")
@Data
public class Questions {
    @Id
    private int id;
    private String category;
    private String question_title;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correct_answer;
}
