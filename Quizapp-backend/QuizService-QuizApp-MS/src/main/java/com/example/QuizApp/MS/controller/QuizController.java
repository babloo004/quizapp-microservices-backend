package com.example.QuizApp.MS.controller;

import com.example.QuizApp.MS.model.QuestionWrapper;
import com.example.QuizApp.MS.model.QuizDto;
import com.example.QuizApp.MS.model.Response;
import com.example.QuizApp.MS.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //creating quiz
    @PostMapping("create")
    public String create(@RequestBody QuizDto quizDto){
        return quizService.create(quizDto.getId(),quizDto.getCategory(),quizDto.getTitle(),quizDto.getNumQ());
    }

    //getting quiz
    @PostMapping("get/{id}")
    public List<QuestionWrapper> getQuiz(@PathVariable int id){
        return quizService.getQuiz(id);
    }

    //getting score
    @PostMapping("submit/{id}")
    public int getScore(@PathVariable int id, @RequestBody List<Response> responses){
        return quizService.getScore(id,responses);
    }
}
