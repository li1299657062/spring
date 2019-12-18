package com.ceic.park.model.park;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("ic2_park_environment")
@Data
public class ParkEnvironment {
    @TableId("id")
    private Integer id;

    private Integer parkId;

    private String envName;

    private String envContent;

    private String rStatus;

    private Date rCreateTime;

    private Date rModifyTime;



}