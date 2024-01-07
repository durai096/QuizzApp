package com.durai096.QuizeApp.Repository;

import com.durai096.QuizeApp.Model.Category;
import com.durai096.QuizeApp.Model.QuestionsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionRepo extends JpaRepository<QuestionsModel,Integer> {

//	@Query("SELECT q FROM QuestionsModel q WHERE q.category_id")
//	List<QuestionsModel> getAllQuestion(Integer category);
    @Query("SELECT q FROM QuestionsModel q WHERE q.category.id = :categoryId")
    List<QuestionsModel> getAllQuestion(@Param("categoryId") int categoryId);


//    List<QuestionsModel> findByCategory(String category);
//    @Query("SELECT q FROM QuestionsModel q WHERE q.category = :category ORDER BY FUNCTION('RAND') LIMIT :numQ")
//    List<QuestionsModel> findRandomQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);
    //List<QuestionsModel>findAllQuestionsByCategory(@Param("category") String category, @Param("numQ") int numQ);

//    @Query("SELECT c.category FROM QuestionsModel c")
//    Set<String> findCategoryNames();

   // List<categoryEntity> getCategoryList();
}
