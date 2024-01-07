package com.durai096.QuizeApp.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngularController {
    @GetMapping("/")
    public String index() {
        return "forward:/path-to-angular-app/index.html";
    }
}
