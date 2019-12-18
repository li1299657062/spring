package com.ceic.park.model.park;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("ic2_park_company")
@Data
public class ParkCompany {
    private Integer parkId;

    private Integer companyNo;

    private String industryCode;

    private String registerCapital;

    private String companyType;

    private String rStatus;

    private Date rCreateTime;

    private Date rModifyTime;


}