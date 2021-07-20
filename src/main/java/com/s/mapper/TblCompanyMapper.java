package com.s.mapper;

import com.s.bean.TblCompany;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 企业档案 Mapper 接口
 * </p>
 *
 * @author smile
 * @since 2021-07-17
 */
@Component
public interface TblCompanyMapper extends BaseMapper<TblCompany> {
    public List<TblCompany> selectCompanyName();

}
