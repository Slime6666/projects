package com.s.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.s.bean.TblUserRecord;
import com.s.service.LoginService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",allowCredentials = "true",methods = {})
public class LogintController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/auth/2step-code")
    public Boolean test(){
        System.out.println("vue自带验证规则");
        return true;
    }
    @RequestMapping("/auth/login")
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password){
        System.out.println(username+"==="+password);
        TblUserRecord tblUserRecord = loginService.login(username, password);
        System.out.println(tblUserRecord);
        return JSONObject.parse(JSONObject.toJSONString(tblUserRecord));
    }
}
