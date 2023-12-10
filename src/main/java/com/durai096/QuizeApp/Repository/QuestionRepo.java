package com.durai096.QuizeApp.Repository;

import com.durai096.QuizeApp.Model.QuestionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionsModel,Integer> {

    List<QuestionsModel> findByCategory(String category);
    @Query("SELECT q FROM QuestionsModel q WHERE q.category = :category ORDER BY FUNCTION('RAND') LIMIT :numQ")
    List<QuestionsModel> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

}
