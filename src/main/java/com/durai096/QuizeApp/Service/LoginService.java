package com.durai096.QuizeApp.Service;

import com.durai096.QuizeApp.Model.LoginModel;
import com.durai096.QuizeApp.Response.LoginRepo;
import com.durai096.QuizeApp.pojo.Login_pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {
    @Autowired
    LoginRepo loginRepo;
    public boolean Login(String user_name,String password)throws Exception
    {
        Optional<LoginModel> people=this.loginRepo.getLoginDetails(user_name,password);
        if (people.isPresent())
        {
           return true;
        }
        else
        {
           return  false;
        }

    }
}
