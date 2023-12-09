package com.durai096.QuizeApp.Model;

import lombok.Data;

@Data
public class QuestWapper {
    int id;
    String question_title;
    String optiona;
    String optionb;
    String optionc;
    String optiond;

    public QuestWapper(int id, String question_title, String optiona, String optionb, String optionc, String optiond) {
        this.id = id;
        this.question_title = question_title;
        this.optiona = optiona;
        this.optionb = optionb;
        this.optionc = optionc;
        this.optiond = optiond;
    }


}
