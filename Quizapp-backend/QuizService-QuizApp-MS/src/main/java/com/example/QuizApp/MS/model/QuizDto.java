package com.example.QuizApp.MS.model;

import lombok.Data;

@Data
public class QuizDto {
    private int id;
    private String category;
    private String title;
    private int numQ;
}
