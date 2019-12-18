package com.ceic.park.model.park;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("ic2_park_investment_cost")
@Data
public class ParkInvestmentCost {
    @TableId("park_id")
    private Integer parkId;

    private String waterPrice;

    private String residentElecPrice;

    private String commerceElecPrice;

    private String greatIndustryElecUsage;

    private String industryElecMaxPrice;

    private String industryElecMinPrice;

    private String industryElecUsualPrice;

    private String gasPrice;

    private String sewageTreatmentPrice;

    private String hasSteam;

    private String heatingPrice;

    private String standardSalaryMin;

    private String workerSalary;

    private String mediumManagerSalary;

    private String seniorManagerSalary;

    private String buildingTax;

    private String landUseTax;

    private String rStatus;

    private Date rCreateTime;

    private Date rModifyTime;


}