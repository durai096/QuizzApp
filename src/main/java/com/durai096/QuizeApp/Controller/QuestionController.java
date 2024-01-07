package com.durai096.QuizeApp.Controller;

import com.durai096.QuizeApp.Model.Category;
import com.durai096.QuizeApp.Model.QuestionsModel;
import com.durai096.QuizeApp.Response.Message;
import com.durai096.QuizeApp.Service.QuestionService;
import com.durai096.QuizeApp.pojo.QuestionVo;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("/getCategory")
    public List<Category> getCategories() {
        return questionService.getAllCategories();
    }

    @GetMapping("/getAllQuestion")
    public List<QuestionsModel> getAllQuestion(@RequestParam int categoryId) {

        return questionService.getAllQuestion(categoryId);
    }

    @GetMapping("allQuestions")
    public ResponseEntity<List<QuestionsModel>>  getAllQuestions(){
        Message res=new Message();
        try {
            return ResponseEntity.ok(questionService.getQuestion());
        }catch (Exception e){
           e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }
    @GetMapping("category/{category}")
        public ResponseEntity<?>getByCategory(@PathVariable String category){
        Message res=new Message();
        try {
            List<QuestionsModel> questions = questionService.getCategory(category);

            if (!questions.isEmpty()) {
                QuestionsModel result = questions.get(0);
                return ResponseEntity.ok(result);
            } else {
                res.setMessage("No questions found for the specified category.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(res);
            }

        } catch (Exception e) {
            res.setMessage("This Category Not Present....");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
        }



    }
//    @GetMapping("getCategory")
//    public List<categoryEntity> getCategory(){
//       return questionService.getByCategory();
//    }
    @PostMapping("/addQuestions")
    public ResponseEntity addQuestions(@RequestBody QuestionVo questionsModel){
        Message res=new Message();
        try {
            questionService.addQuestion(questionsModel);
            res.setMessage("Question Added Successfully.....");
            return ResponseEntity.ok(res);
        }catch(Exception e){
            res.setMessage("Question Not Added.........");
            return ResponseEntity.badRequest().body(res);

        }
    }
    @DeleteMapping("deleteQuestion/{id}")
    public ResponseEntity deleteQuestion(@PathVariable  int id){
       Message res=new Message();
         try {

             questionService.deleteQuestionById(id);
             res.setMessage("Question Delete Successfully...");
             return ResponseEntity.ok().body(res);

         }catch (Exception e){
             res.setMessage("Question Not Found");
             return ResponseEntity.badRequest().body(res);

         }



    }
    @PutMapping("UpdateQuestions/{id}")
    public ResponseEntity updateQuestions(@PathVariable int id,@RequestBody QuestionsModel updateModelQuestions){
        Message res=new Message();
        try {
            updateModelQuestions.setId(id);
            questionService.updateQuestion(updateModelQuestions);
            res.setMessage("Question Updated Successfully....");
            return ResponseEntity.ok().body(res);
        }catch (Exception e){
            res.setMessage("Question Not Updated. ID Not Present.....");
            return ResponseEntity.badRequest().body(res);
        }

    }

}
