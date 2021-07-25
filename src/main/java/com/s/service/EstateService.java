package com.s.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.s.bean.FcBuilding;
import com.s.bean.FcEstate;
import com.s.bean.TblCompany;
import com.s.mapper.FcBuildingMapper;
import com.s.mapper.FcEstateMapper;
import com.s.mapper.TblCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstateService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    @Autowired
    private FcEstateMapper fcEstateMapper;
    @Autowired
    private FcBuildingMapper fcBuildingMapper;
    public List<TblCompany> selectCompany(){
        List<TblCompany> companys = tblCompanyMapper.selectCompanyName();
        return companys;
    }

    //插入楼盘信息
    public Integer insertEstate(FcEstate fcEstate){
        //创建查询包装类
        QueryWrapper queryWrapper = new QueryWrapper();
        //判断楼盘 编号是否存在
        queryWrapper.eq("estate_code",fcEstate.getEstateCode());
        //查询的返回结果
        FcEstate findResult = fcEstateMapper.selectOne(queryWrapper);
        int result = 0;//定义一个返回结果
        if (findResult != null){
            return result;
        }else {
            //没有插入过的编码，直接插入
            result = fcEstateMapper.insert(fcEstate);
            return  result;
        }
    }

    //楼宇查询
    public List<FcBuilding> selectBuilding(Integer buildingNumber,String estateCode){
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for (int i = 0; i < buildingNumber; i++) {
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setBuildingCode("B"+i+1);
            fcBuilding.setBuildingName("第"+(i+1)+"号楼");
            fcBuilding.setEstateCode(estateCode);
            fcBuildingMapper.insert(fcBuilding);
            fcBuildings.add(fcBuilding);
        }
        return fcBuildings;
    };

    //楼宇信息修改
    public Integer updateBuilding(FcBuilding fcBuilding){
        int result = fcBuildingMapper.updateById(fcBuilding);
        return result;
    }
}
