package com.durai096.QuizeApp.Service;
import com.durai096.QuizeApp.Model.QuestWapper;
import com.durai096.QuizeApp.Model.QuestionsModel;
import com.durai096.QuizeApp.Model.QuizModule;
import com.durai096.QuizeApp.Repository.QuestionRepo;
import com.durai096.QuizeApp.Repository.QuizRepo;
import com.durai096.QuizeApp.Response.AnswerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int numQ, String questionTitle) {
        List<QuestionsModel> questionsModelQuiz=questionRepo.findRandomQuestionsByCategory(category,numQ);
        QuizModule quiz=new QuizModule();
        quiz.setQuestion_title(questionTitle);
        quiz.setQuestionsModelList(questionsModelQuiz);
        quizRepo.save(quiz);
        return new ResponseEntity<>("Quiz Created Successfully.....", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestWapper>> getQuizQuestion(Integer id) {
        Optional<QuizModule> quiz= quizRepo.findById(id);
        List<QuestionsModel> questionsFromDB=quiz.get().getQuestionsModelList();
        List<QuestWapper> questionsFromUser=new ArrayList<>();
        for (QuestionsModel q:questionsFromDB){
            QuestWapper qw= new QuestWapper(q.getId(),q.getQuestion_title(),q.getOptiona(),q.getOptionb(),q.getOptionc(),q.getOptiond());
            questionsFromUser.add(qw);
        }


        return new ResponseEntity<>(questionsFromUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateQuizAnswer(Integer id, List<AnswerResponse> answerResponses) {

        QuizModule quizmodule=quizRepo.findById(id).get();
        List<QuestionsModel> questionsmodule=quizmodule.getQuestionsModelList();
        int right=0;
        int i=0;

        for (AnswerResponse res: answerResponses){
            if (res.getResponse().equals(questionsmodule.get(i).getCorrect_anwser())) {
                    right++;
                i++;
            }

        }
       return new ResponseEntity<>(right,HttpStatus.OK);

    }
}
