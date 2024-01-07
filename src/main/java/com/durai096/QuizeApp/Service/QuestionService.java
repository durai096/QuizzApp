package com.durai096.QuizeApp.Service;

import com.durai096.QuizeApp.Model.Category;
import com.durai096.QuizeApp.Model.QuestionsModel;
import com.durai096.QuizeApp.Repository.CategoryRepo;
import com.durai096.QuizeApp.Repository.QuestionRepo;
import com.durai096.QuizeApp.Response.LoginRepo;
import com.durai096.QuizeApp.pojo.QuestionVo;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepo questionRepo;

//    @Autowired
//    LoginRepo loginRepo;

    @Autowired
    private CategoryRepo categoryDao;
    
    public List<QuestionsModel> getAllQuestion(Integer categoryId) {
    	
    	Optional<Category> category =  categoryDao.findById(categoryId);
    	
    	 List<QuestionsModel> data =  questionRepo.getAllQuestion(categoryId);
    	 return data;
    }

    public List<Category> getAllCategories() {
        return categoryDao.findAll();
    }


    public List<QuestionsModel> getQuestion(){
       return questionRepo.findAll();
    }

    public List<QuestionsModel> getCategory(String category) {
//       return questionRepo.findByCategory(category);
    	return null;

    }

    public void addQuestion(QuestionVo questionsModel) {
    	
    	Optional<Category> data =  categoryDao.findById(questionsModel.getCategory());
    	 
    	QuestionsModel question = new QuestionsModel();
    	question.setCategory(data.get());
    	question.setCorrect_anwser(questionsModel.getCorrect_anwser());
    	question.setOptiona(questionsModel.getOptiona());
    	question.setOptionb(questionsModel.getOptionb());
    	question.setOptionc(questionsModel.getOptionc());
    	question.setOptiond(questionsModel.getOptiond());
    	question.setQuestion_title(questionsModel.getQuestion_title());
    	
        questionRepo.save(question);
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
