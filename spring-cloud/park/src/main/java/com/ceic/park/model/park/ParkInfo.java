package com.ceic.park.model.park;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@TableName("ic2_park_info")
public class ParkInfo {
    @TableId(value = "park_id")
    private int parkId;

    private String chainCode;

    private String parkType;

    private String regionCode;

    private String parkArea;

    private String parkName;

    private String parkAddress;

    private String parkContacts;

    private String parkEmail;

    private String parkPhone;

    private String parkLeadingIndustry;

    private String cityAddress;

    private int companyCount;

    private int employeeCount;

    private String longitude;

    private String latitude;

    private String sortNo;

    private String rStatus;

    private Date rCreateTime;

    private Date rModifyTime;

    private List<ParkCompany> parkCompanyList;

    private List<ParkEnvironment> parkEnvironmentList;

    private ParkInvestmentCost parkInvestmentCost;

    private ParkMerchant parkMerchant;

    private ParkResource parkResource;

    private String parkTypeName;




}