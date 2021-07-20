package com.s.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.s.bean.TblUserRecord;
import com.s.returnjson.Permission;
import com.s.returnjson.Permissions;
import com.s.returnjson.ReturnObejct;
import com.s.returnjson.UserInfo;
import com.s.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

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
    public Object login(@RequestParam("username") String username, @RequestParam("password") String password,HttpSession session){
        System.out.println(username+"==="+password);
        TblUserRecord tblUserRecord = loginService.login(username, password);
        //将用户数据写入到session
        session.setAttribute("userRecord",tblUserRecord);
        ReturnObejct returnObejct = new ReturnObejct(tblUserRecord);
        tblUserRecord.setToken(tblUserRecord.getUserName());
        //System.out.println(tblUserRecord);
        /*JSONObject.parse(String)，将字符串转换成jsonobject对象。
        * JSONObject.toJSONString，将json对象-》json字符串
        * */
        return JSONObject.parse(JSONObject.toJSONString(returnObejct));
    }
    //用户根据权限登录
    @RequestMapping("/user/info")
    public String getInfo(HttpSession session){
        //获取用户数据
        TblUserRecord tbluserRecord = (TblUserRecord) session.getAttribute("userRecord");
        //获取权限模块信息
        String[] split = tbluserRecord.getTblRole().getRolePrivileges().split("-");
        //创建权限集合对象
        Permissions permissions = new Permissions();
        //向权限集合对象添加具体权限
        List<Permission> permissionsList = new ArrayList<>();
        for (String s : split) {
            permissionsList.add(new Permission(s));
        }
        permissions.setPermissions(permissionsList);
        //设置返回值
        UserInfo userInfo = new UserInfo(tbluserRecord.getUserName(),permissions);
        return JSONObject.toJSONString(new ReturnObejct(userInfo));
    }
    //退出登录
    @RequestMapping("/auth/logout")
    public String logOut(HttpSession session){
        //System.out.println("louOut");
        //销毁会话，退出登录
        session.invalidate();
        return "";
    }
}
