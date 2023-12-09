package com.durai096.QuizeApp.Repository;

import com.durai096.QuizeApp.Model.QuestionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionsModel,Integer> {

    List<QuestionsModel> findByCategory(String category);
    @Query(value = "SELECT * FROM QuestionsModel q where q.category=:category ORDER BY RANDOM() LIMIT :numQ",nativeQuery = true)

    List<QuestionsModel> findRandomQuestionsByCategory(String category, int numQ);

}
