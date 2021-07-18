package com.s.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true",methods = {})
public class LogintController {
    @RequestMapping("/auto/login")
    public String test(){
        System.out.println("test");
        return "";
    }
}
