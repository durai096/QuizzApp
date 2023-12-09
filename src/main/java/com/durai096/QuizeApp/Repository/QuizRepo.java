package com.durai096.QuizeApp.Repository;

import com.durai096.QuizeApp.Model.QuizModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepo extends JpaRepository<QuizModule,Integer> {

}
