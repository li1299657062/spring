package com.ceic.park.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceic.park.model.park.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParkInfoMapper extends BaseMapper<ParkInfo> {
    Map selectParkInfo(@Param("params") Map<String, Object> params);

    List<Map> selectCityPark(@Param("params")Map<String, Object> params);

    List<ParkInfo> selectTopPark(@Param("params")Map<String, Object> params);

    ParkInfo selectOnePark(@Param("parkId")String parkId);

    Map selectMerchant(@Param("parkId")String parkId);

    Map selectResource(@Param("parkId")String parkId);

    Map selectInvestmentCost(@Param("parkId")String parkId);

    List<Map> selectEnvironment(@Param("parkId")String parkId);

    List<Map> selectParkCompany(@Param("parkId")String parkId);

    List<Map> selectIndustyCompany(@Param("industryCode")String industryCode,@Param("parkId")String parkId);

    //下面为后台园区管理接口
    List<ParkInfo> selectParkInfoManage(@Param("params")Map<String, Object> params);

    ParkInfo selectOneParkInfo(@Param("parkId")String parkId);

    List<ParkCompany> selectParkCompanyList(@Param("parkId")String parkId);

    List<ParkEnvironment> selectParkEnvironmentList(@Param("parkId")String parkId);

    ParkInvestmentCost selectParkInvestmentCost(@Param("parkId")String parkId);

    ParkMerchant selectParkMerchant(@Param("parkId")String parkId);

    ParkResource selectParkResource(@Param("parkId")String parkId);

    void deleteParkInfo(@Param("parkId") int parkId);

    void insertParkInfo(ParkInfo parkInfo);

    List<Map> selectIndustry();
}