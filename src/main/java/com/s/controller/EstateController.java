package com.s.controller;

import com.alibaba.fastjson.JSONObject;
import com.s.bean.TblCompany;
import com.s.returnjson.ReturnObejct;
import com.s.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.security.PublicKey;
import java.util.List;

@Controller
public class EstateController {
    @Autowired
    private EstateService estateService;
    public String selectCompany(){
        List<TblCompany> tblCompanies = estateService.selectCompany();
        return JSONObject.toJSONString(new ReturnObejct(tblCompanies));
    }
}
