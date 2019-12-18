package com.ceic.park.model.park;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ic2_park_resource")
public class ParkResource {
    @TableId("park_id")
    private Integer parkId;

    private String localPopulation;

    private String migrantPopulation;

    private String university;

    private String graduates;

    private String isIndependentFinancial;

    private String rStatus;

    private Date rCreateTime;

    private Date rModifyTime;


}