package com.durai096.QuizeApp.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Data
//@Table(name ="quiz")
public class QuizModule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String question_title;
    @ManyToMany
    private List<QuestionsModel> questionsModelList;
}
