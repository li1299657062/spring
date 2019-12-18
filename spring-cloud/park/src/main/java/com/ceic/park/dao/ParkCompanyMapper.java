package com.ceic.park.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceic.park.model.park.ParkCompany;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkCompanyMapper  extends BaseMapper<ParkCompany>{
    void insertParkCompany(@Param("companyList") List<ParkCompany> parkCompanyList);

    void updateParkCompany(@Param("companyList") List<ParkCompany> parkCompanyList);

    void deleteParkCompany(@Param("companyList") List<ParkCompany> parkCompanyList);
}