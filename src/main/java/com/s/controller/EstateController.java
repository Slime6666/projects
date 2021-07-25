package com.s.controller;

import com.alibaba.fastjson.JSONObject;
import com.s.bean.FcBuilding;
import com.s.bean.FcEstate;
import com.s.bean.TblCompany;
import com.s.returnjson.ReturnObejct;
import com.s.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return JSONObject.toJSONString(new ReturnObejct(tblCompanies));
    }
    @RequestMapping("/estate/insertEstate")
    public String insertEstate(FcEstate fcEstate){
        Integer result = estateService.insertEstate(fcEstate);
        //System.out.println("result"+result);
        if (result == 0){
            return  JSONObject.toJSONString(new ReturnObejct("0","编码已存在"));
        }
        return JSONObject.toJSONString(new ReturnObejct("1","插入成功"));
    }

    /*
    * 楼宇查询
    * */

    @RequestMapping("/estate/selectBuilding")
    public String selectBuilding(Integer buildingNumber,String estateCode){
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);
        //System.out.println("selectBuilding");
        return JSONObject.toJSONString(new ReturnObejct(fcBuildings));
    }

    /*
     * 编辑楼宇信息
     * */
    @RequestMapping("/estate/updateBuilding")
    public String selectBuilding(FcBuilding fcBuilding){
        System.out.println("updateBuilding");
        Integer result = estateService.updateBuilding(fcBuilding);
        if (result == 1){
            return JSONObject.toJSONString(new ReturnObejct("1","楼宇修改成功"));
        }else {
            return JSONObject.toJSONString(new ReturnObejct("0","楼宇修改失败"));
        }
    }
}
