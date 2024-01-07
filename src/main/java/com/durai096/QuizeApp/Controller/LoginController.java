package com.durai096.QuizeApp.Controller;

import com.durai096.QuizeApp.Response.Message;
import com.durai096.QuizeApp.Service.LoginService;
import com.durai096.QuizeApp.Service.QuestionService;
import com.durai096.QuizeApp.pojo.Login_pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("adminLogin")
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("login")
    public ResponseEntity Login(@RequestBody Login_pojo loginVo){
        Message res=new Message();
        try {
           if(loginService.Login(loginVo.getUser_name(),loginVo.getPassword())){
               res.setMessage("Login Successfully");
               return ResponseEntity.ok(res);
           }

        }catch (Exception e){
            res.setMessage("Invalid User");
            return ResponseEntity.badRequest().body(res);
        }
        return  null;
}
}
