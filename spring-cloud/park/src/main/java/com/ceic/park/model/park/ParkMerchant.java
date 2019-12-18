package com.ceic.park.model.park;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("ic2_park_merchant")
@Data
public class ParkMerchant {
    @TableId("park_id")
    private Integer parkId;

    private String landPrice;

    private String taxRequirement;

    private String investmentStrength;

    private String environmentalRequirement;

    private String landArea;

    private String indexRequired;

    private String gdpPerYear;

    private String fiscalRevenue;

    private String settledEnterprise;

    private String workshopRentalPrice;

    private String workshopSellingPrice;

    private String officeRentalPrice;

    private String rStatus;

    private Date rCreateTime;

    private Date rModifyTime;


}