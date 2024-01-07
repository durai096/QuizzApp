package com.durai096.QuizeApp.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="login_details")
public class LoginModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String user_name;
    String password;
//    String email_id;
}
