package com.durai096.QuizeApp.pojo;

import com.durai096.QuizeApp.Model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionVo {

	    String question_title;
	    String optiona;
	    String optionb;
	    String optionc;
	    String optiond;
	    String correct_anwser;
	    private Integer category;
}
