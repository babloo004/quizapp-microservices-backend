package com.example.QuizApp.MS.service;

import com.example.QuizApp.MS.fieg.QuizInterface;
import com.example.QuizApp.MS.model.QuestionWrapper;
import com.example.QuizApp.MS.model.Quiz;
import com.example.QuizApp.MS.model.Response;
import com.example.QuizApp.MS.repository.QuizRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizInterface quizInterface;

    @Autowired
    QuizRepo quizRepo;

    public String create(int id,String category,String title,int numQ){
        List<Integer> qids = quizInterface.generate(category,numQ);
        Quiz quiz = new Quiz();
        quiz.setId(id);
        quiz.setQuiz_title(title);
        quiz.setQuestionIds(qids);
        quizRepo.save(quiz);
        return "Success";
    }

    public List<QuestionWrapper> getQuiz(int id){
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> qids = quiz.getQuestionIds();
        return quizInterface.getQuestionsById(qids);
    }

    public int getScore(int id,List<Response> responses){
        return quizInterface.getScore(responses);
    }
}
