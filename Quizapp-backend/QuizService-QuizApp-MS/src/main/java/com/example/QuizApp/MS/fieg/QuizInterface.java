package com.example.QuizApp.MS.fieg;

import com.example.QuizApp.MS.model.QuestionWrapper;
import com.example.QuizApp.MS.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QuestionService-QuizApp-MS")
public interface QuizInterface {

    @GetMapping("question/generate")
    public List<Integer> generate(@RequestParam  String category,@RequestParam int numQ);

    @PostMapping("question/getQuestions")
    public List<QuestionWrapper> getQuestionsById(@RequestBody List<Integer> ids);

    @PostMapping("question/score")
    public int getScore(@RequestBody List<Response> responses);
}
