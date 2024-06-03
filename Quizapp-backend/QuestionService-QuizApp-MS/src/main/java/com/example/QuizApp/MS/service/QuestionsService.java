package com.example.QuizApp.MS.service;

import com.example.QuizApp.MS.model.QuestionWrapper;
import com.example.QuizApp.MS.model.Questions;
import com.example.QuizApp.MS.model.Response;
import com.example.QuizApp.MS.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionsService {

    @Autowired
    QuestionsRepo questionsRepo;

    public List<Questions> getAll(){
        return questionsRepo.findAll();
    }

    public List<Questions> catQns(String category){return questionsRepo.findByCategory(category);}

    public String addQns(Questions questions){
        questionsRepo.save(questions);
        return "Success...!";
    }

    public List<Integer> generate(String category,int numQ){return questionsRepo.findByCategoryRand(category,numQ);}

    public List<QuestionWrapper> getQuestionsById(List<Integer> ids){
        List<QuestionWrapper> qw = new ArrayList<>();
        List<Questions> qns = new ArrayList<>();

        for(Integer id : ids){
            qns.add(questionsRepo.findById(id).get());
        }

        for(Questions qn : qns ){
            QuestionWrapper wrap = new QuestionWrapper();
            wrap.setId(qn.getId());
            wrap.setQuestion_title(qn.getQuestion_title());
            wrap.setOption1(qn.getOption1());
            wrap.setOption2(qn.getOption2());
            wrap.setOption3(qn.getOption3());
            wrap.setOption4(qn.getOption4());
            qw.add(wrap);
        }

        System.out.println(qw);
        return qw;
    }

    public int getScore(List<Response> response){
        int right = 0;
        for(Response res : response){
            Questions q = questionsRepo.findById(res.getId()).get();
            if(res.getResponse().equals(q.getCorrect_answer())) right++;
        }
        return right;
    }
}
