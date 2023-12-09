package com.durai096.QuizeApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="questions")
public class QuestionsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String question_title;
    String optiona;
    String optionb;
    String optionc;
    String optiond;
    String correct_anwser;
    String category;
}
