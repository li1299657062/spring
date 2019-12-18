package com.ceic.park.service;



import com.ceic.park.biz.ParkBizService;
import com.ceic.park.model.*;
import com.ceic.park.model.park.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/park")
@Api(value = "/park", description = "园区服务")
public class ParkService {
   @Autowired
   private ParkBizService parkBizServiceImpl;

    @ApiOperation(value = "后台园区查询", notes = "李航")
    @GetMapping("/parkInfo")
    public Result<List<ParkInfo>> selectParkInfo(ParkRequest parkRequest) {
        Result<List<ParkInfo>> result = parkBizServiceImpl.selectParkInfo(parkRequest);
        return result;
    }

    @ApiOperation(value = "编辑接口跳转", notes = "李航")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parkId", value = "园区编号", required = true)
    })
    @GetMapping("/selectOnePark")
    public ParkInfo selectOnePark(String parkId) {
        ParkInfo parkInfo = parkBizServiceImpl.selectOnePark(parkId);
        return parkInfo;
    }

    @ApiOperation(value = "刪除园区", notes = "李航")
    @GetMapping("/deleteParkInfo")
    public Response deleteParkInfo(@RequestBody List<ParkInfo> parkInfos){
        if(parkInfos==null||parkInfos.size()==0){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
        try {
            parkBizServiceImpl.deleteParkInfo(parkInfos);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "插入园区信息", notes = "李航")
    @GetMapping("/insertParkInfo")
    public JSONObject insertParkInfo(ParkInfo parkInfo){
        JSONObject jsonObject=new JSONObject();
        try{
            int parkId = parkBizServiceImpl.insertParkInfo(parkInfo);
            jsonObject.put("code", HttpStatus.OK.value());
            jsonObject.put("msg","操作成功");
            jsonObject.put("parkId",parkId);
            return jsonObject;
        }catch (Exception e){
            jsonObject.put("code", HttpStatus.UNAUTHORIZED.value());
            jsonObject.put("msg","操作失败");
            return jsonObject;
        }
    }

    @ApiOperation(value = "插入园区投资成本", notes = "李航")
    @GetMapping("/insertParkInvestmentCost")
    public Response insertParkInvestmentCost(ParkInvestmentCost parkInvestmentCost){
        try {
            parkBizServiceImpl.insertParkInvestmentCost(parkInvestmentCost);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "插入园区招商信息", notes = "李航")
    @GetMapping("/insertParkMerchant")
    public Response insertParkMerchant(ParkMerchant parkMerchant){
        try {
            parkBizServiceImpl.insertParkMerchant(parkMerchant);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "插入园区资源", notes = "李航")
    @GetMapping("/insertParkResource")
    public Response insertParkResource(ParkResource parkResource){
        try {
            parkBizServiceImpl.insertParkResource(parkResource);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "插入园区公司", notes = "李航")
    @GetMapping("/insertParkCompany")
    public Response insertParkCompany(List<ParkCompany> parkCompanyList){
        try {
            parkBizServiceImpl.insertParkCompany(parkCompanyList);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "插入园区环境", notes = "李航")
    @GetMapping("/insertParkEnvironment")
    public Response insertParkEnvironment(List<ParkEnvironment> parkEnvironmentList){
        try {
            parkBizServiceImpl.insertParkEnvironment(parkEnvironmentList);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }


    @ApiOperation(value = "更新园区信息", notes = "李航")
    @GetMapping("/updateParkInfo")
    public Response updateParkInfo(ParkInfo parkInfo){
        try {
            parkBizServiceImpl.updateParkInfo(parkInfo);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "更新园区投资成本", notes = "李航")
    @GetMapping("/updateParkInvestmentCost")
    public Response updateParkInvestmentCost(ParkInvestmentCost parkInvestmentCost){
        try {
            parkBizServiceImpl.updateParkInvestmentCost(parkInvestmentCost);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "更新园区招商信息", notes = "李航")
    @GetMapping("/updateParkMerchant")
    public Response updateParkMerchant(ParkMerchant parkMerchant){
        try {
            parkBizServiceImpl.updateParkMerchant(parkMerchant);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "更新园区资源", notes = "李航")
    @GetMapping("/updateParkResource")
    public Response updateParkResource(ParkResource parkResource){
        try {
            parkBizServiceImpl.updateParkResource(parkResource);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "更新园区公司", notes = "李航")
    @GetMapping("/updateParkCompany")
    public Response updateParkCompany(List<ParkCompany> parkCompanyList){
        try {
            parkBizServiceImpl.updateParkCompany(parkCompanyList);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "更新园区环境", notes = "李航")
    @GetMapping("/updateParkEnvironment")
    public Response updateParkEnvironment(List<ParkEnvironment> parkEnvironmentList){
        try {
            parkBizServiceImpl.updateParkEnvironment(parkEnvironmentList);
            return Response.build(String.valueOf(HttpStatus.OK.value()),"操作成功");
        }catch (Exception e){
            return Response.build(String.valueOf(HttpStatus.UNAUTHORIZED.value()),"操作失败");
        }
    }

    @ApiOperation(value = "下啦框", notes = "李航\n"+
    "COMPANY_TYPE=获取公司类型，PARK_TYPE获取园区类型，CHAIN=获取产业链类型，COMPANY_INDUSTRY=获取公司产业类型,PARK_INDUSTRY_TYPE=获取园区主导产业")
    @GetMapping("/getSelect")
    public List getSelect(ParkRequest parkRequest){
        return parkBizServiceImpl.getSelect(parkRequest);
    }




}
