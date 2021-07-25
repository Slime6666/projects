package com.s.service;

import com.s.bean.TblUserRecord;
import com.s.mapper.TblUserRecordMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class LoginService {
    @Autowired
    private TblUserRecordMapper tblUserRecordMapper;

    public TblUserRecord login(String username,String password){
        return tblUserRecordMapper.login(username,password);
    }
}
