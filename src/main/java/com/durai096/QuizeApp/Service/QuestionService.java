package com.durai096.QuizeApp.Service;

import com.durai096.QuizeApp.Model.QuestionsModel;
import com.durai096.QuizeApp.Repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;
    public List<QuestionsModel> getQuestion(){
       return questionRepo.findAll();
    }

    public List<QuestionsModel> getCategory(String category) {
       return questionRepo.findByCategory(category);


    }

    public void addQuestion(QuestionsModel questionsModel) {
        questionRepo.save(questionsModel);
    }

    public void deleteQuestionById(int id) throws Exception {
        Optional<QuestionsModel>questionsModelOptional=questionRepo.findById(id);

            if (questionsModelOptional.isPresent()){
                questionRepo.deleteById(id);
            }else{
                throw new Exception("Question Not Found");
            }



    }

    public void updateQuestion(QuestionsModel updateModelQuestions) throws Exception {
        Optional<QuestionsModel> updatequs=questionRepo.findById(updateModelQuestions.getId());
        if (updatequs.isPresent()){
            questionRepo.save(updateModelQuestions);
        }else {
            throw new Exception("Question With ID"+ updateModelQuestions.getId() +" Not Found");
        }
    }
}
