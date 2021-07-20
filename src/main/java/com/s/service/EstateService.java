package com.s.service;

import com.s.bean.TblCompany;
import com.s.mapper.TblCompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateService {
    @Autowired
    private TblCompanyMapper tblCompanyMapper;
    public List<TblCompany> selectCompany(){
        List<TblCompany> companys = tblCompanyMapper.selectCompanyName();
        return companys;
    }
}
