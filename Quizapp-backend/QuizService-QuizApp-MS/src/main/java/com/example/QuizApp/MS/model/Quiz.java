package com.example.QuizApp.MS.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Quiz {
    @Id
    private Integer id;
    private String quiz_title;

    @ElementCollection
    private List<Integer> questionIds;
}
