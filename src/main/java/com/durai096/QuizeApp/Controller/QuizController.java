package com.durai096.QuizeApp.Controller;

import com.durai096.QuizeApp.Model.QuestWapper;
import com.durai096.QuizeApp.Model.QuestionsModel;
import com.durai096.QuizeApp.Response.AnswerResponse;
import com.durai096.QuizeApp.Response.Message;
import com.durai096.QuizeApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ,@RequestParam String question_title){
        return quizService.createQuiz(category,numQ,question_title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestWapper>> getQuizQuestions(@PathVariable Integer id){
        Message res=new Message();
        try {
            return quizService.getQuizQuestion(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
            //we need to add error message
        }

    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<AnswerResponse> answerResponses){
        Message res=new Message();

            return quizService.calculateQuizAnswer(id,answerResponses);
    }

}
