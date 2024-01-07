package com.durai096.QuizeApp.Response;

import com.durai096.QuizeApp.Model.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepo extends JpaRepository<LoginModel,Integer> {
    @Query("SELECT login FROM LoginModel login WHERE login.user_name = ?1 AND login.password = ?2")
    Optional<LoginModel> getLoginDetails(String user_name, String password);
}
