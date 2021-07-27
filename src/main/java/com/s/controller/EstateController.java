package com.s.controller;

import com.alibaba.fastjson.JSONObject;
import com.s.bean.FcBuilding;
import com.s.bean.FcEstate;
import com.s.bean.FcUnit;
import com.s.bean.TblCompany;

import com.s.returnjson.ReturnObject;
import com.s.service.EstateService;
import com.s.vo.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {},allowCredentials = "true")
public class EstateController {
    @Autowired
    private EstateService estateService;
    
    @RequestMapping("/estate/selectCompany")
    public String selectCompany(){
        List<TblCompany> tblCompanies = estateService.selectCompany();
        //System.out.println(tblCompanies);
        return JSONObject.toJSONString(new ReturnObject(tblCompanies));
    }
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        Integer result = estateService.insertEstate(fcEstate);
        //System.out.println("result"+result);
        if (result == 0){
            return  JSONObject.toJSONString(new ReturnObject("0","编码已存在"));
        }
        return JSONObject.toJSONString(new ReturnObject("1","插入成功"));
    }

    /*
    * 楼宇查询
    * */

    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber,String estateCode){
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);
        //System.out.println("selectBuilding");
        return JSONObject.toJSONString(new ReturnObject(fcBuildings));
    }

    /*
     * 编辑楼宇信息
     * */
    @RequestMapping("/estate/updateBuilding")
    public String selectBuilding(FcBuilding fcBuilding){
        System.out.println("updateBuilding");
        Integer result = estateService.updateBuilding(fcBuilding);
        if (result == 1){
            return JSONObject.toJSONString(new ReturnObject("楼宇修改成功"));
        }else {
            return JSONObject.toJSONString(new ReturnObject("楼宇修改失败"));
        }
    }

    @RequestMapping("/estate/selectUnit")
    public String selectUnit(@RequestBody UnitMessage[] unitMessages){
        System.out.println("estate selectUnit");
        List<FcUnit> allUnit = new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            allUnit.addAll(estateService.selectUnit(unitMessage));
        }
        return  JSONObject.toJSONString(new ReturnObject(allUnit));
    }

    @RequestMapping("/estate/updateUnit")
    public String updateUnit(FcUnit fcUnit){
        int res = estateService.updateUnit(fcUnit);
        if (res == 1){
            return JSONObject.toJSONString(new ReturnObject("更新单元成功"));
        }else {
            return JSONObject.toJSONString(new ReturnObject("更新单元失败"));
        }
    }
}
