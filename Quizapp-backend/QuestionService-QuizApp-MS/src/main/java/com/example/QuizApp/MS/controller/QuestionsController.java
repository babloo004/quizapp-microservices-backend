package com.example.QuizApp.MS.controller;

import com.example.QuizApp.MS.model.QuestionWrapper;
import com.example.QuizApp.MS.model.Questions;
import com.example.QuizApp.MS.model.Response;
import com.example.QuizApp.MS.service.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionsController {

    @Autowired
    QuestionsService questionsService;

    @GetMapping("all")
    public List<Questions> getAll(){
        return  questionsService.getAll();
    }

    @GetMapping("category")
    public List<Questions> catQns(@RequestParam String category){return questionsService.catQns(category);}

    @PostMapping("add")
    public String addQns(@RequestBody Questions questions){return questionsService.addQns(questions);}

    @GetMapping("generate")
    public List<Integer> generate(@RequestParam  String category,@RequestParam int numQ){return questionsService.generate(category,numQ);}

    @PostMapping("getQuestions")
    public List<QuestionWrapper> getQuestionsById(@RequestBody List<Integer> ids){return questionsService.getQuestionsById(ids);}

    @PostMapping("score")
    public int getScore(@RequestBody List<Response> responses){
        return questionsService.getScore(responses);
    }
}
