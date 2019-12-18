package com.ceic.park.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceic.park.model.park.ParkEnvironment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkEnvironmentMapper extends BaseMapper<ParkEnvironment> {
    void insertParkEnvironment(@Param("environmentList")List<ParkEnvironment> parkEnvironmentList);

    void updateParkEnvironment(@Param("environmentList")List<ParkEnvironment> parkEnvironmentList);
}