package com.ceic.park.biz.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ceic.park.biz.ParkBizService;
import com.ceic.park.dao.*;
import com.ceic.park.model.*;
import com.ceic.park.model.park.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ParkBizServiceImpl implements ParkBizService {
    @Autowired
    private ParkInfoMapper parkInfoMapper;
    @Autowired
    private ParkEnvironmentMapper parkEnvironmentMapper;
    @Autowired
    private ParkCompanyMapper parkCompanyMapper;
    @Autowired
    private ParkMerchantMapper parkMerchantMapper;
    @Autowired
    private ParkResourceMapper parkResourceMapper;
    @Autowired
    private  ParkInvestmentCostMapper parkInvestmentCostMapper;
//    @Autowired
//    private DictDefMapper dictDefMapper;
//    @Autowired
//    private DictRegionMapper dictRegionMapper;
//    @Autowired
//    private DictIndustryChainMapper dictIndustryChainMapper;


    @Override
    public Result<List<ParkInfo>> selectParkInfo(ParkRequest parkRequest) {
//        Page<?> startPage = PageHelper.startPage(parkRequest.getCurrentPage(), parkRequest.getPageSize(), true);
//        List<ParkInfo> parkInfos = parkInfoMapper.selectParkInfoManage(parkRequest.getMaps());
//        for(ParkInfo parkInfo:parkInfos){
//            DictDef dictDef = dictDefMapper.selectOne(new QueryWrapper<DictDef>().eq("dict_id", "PARK_TYPE").eq("dict_code", parkInfo.getParkType()));
//            parkInfo.setParkTypeName(dictDef.getCodeName());
//            DictRegion dictRegion = dictRegionMapper.selectRegionNames(parkInfo.getRegionCode());
//            if(dictRegion!=null)
//            parkInfo.setCityAddress(dictRegion.getCountryName()+"-"+dictRegion.getProvinceName()+"-"+dictRegion.getCityName());
//        }
//        Result<List<ParkInfo>> result=new Result<>(parkInfos);
//        result.setPageInfo(parkRequest.getCurrentPage(), parkRequest.getPageSize(), startPage.getTotal());
//        return  result;
        return null;
    }

    @Override
    public ParkInfo selectOnePark(String parkId) {
        ParkInfo parkInfo = parkInfoMapper.selectOneParkInfo(parkId);
        if(parkInfo!=null) {
            List<ParkCompany> parkCompanies = parkInfoMapper.selectParkCompanyList(parkId);
            List<ParkEnvironment> parkEnvironments = parkInfoMapper.selectParkEnvironmentList(parkId);
            ParkInvestmentCost parkInvestmentCost = parkInfoMapper.selectParkInvestmentCost(parkId);
            ParkMerchant parkMerchant = parkInfoMapper.selectParkMerchant(parkId);
            ParkResource parkResource = parkInfoMapper.selectParkResource(parkId);
            parkInfo.setParkCompanyList(parkCompanies);
            parkInfo.setParkEnvironmentList(parkEnvironments);
            parkInfo.setParkInvestmentCost(parkInvestmentCost);
            parkInfo.setParkMerchant(parkMerchant);
            parkInfo.setParkResource(parkResource);
        }
        return parkInfo;
    }

    @Override
    @Transactional
    public void deleteParkInfo(List<ParkInfo> parkInfos) {
        for (ParkInfo parkInfo :parkInfos){
            ParkInfo selectOneParkInfo = parkInfoMapper.selectOneParkInfo(parkInfo.getParkId() + "");
            if(selectOneParkInfo==null) break;
            if(selectOneParkInfo.getChainCode().contains(parkInfo.getChainCode())&&!selectOneParkInfo.getChainCode().contains("|")){
                parkInfoMapper.deleteParkInfo(selectOneParkInfo.getParkId());
            }else if (selectOneParkInfo.getChainCode().contains(parkInfo.getChainCode())&&selectOneParkInfo.getChainCode().contains("|")){
                String[] split = selectOneParkInfo.getChainCode().split("\\|");
                String updateChainCode="";
                for(String str:split){
                    if(!str.equals(parkInfo.getChainCode()))
                        updateChainCode+=str+"|";
                }
                selectOneParkInfo.setChainCode(updateChainCode.substring(0, updateChainCode.length() - 1));
                parkInfoMapper.updateById(selectOneParkInfo);
            }
        }
    }

    @Override
    @Transactional
    public int insertParkInfo(ParkInfo parkInfo) {
        parkInfoMapper.insertParkInfo(parkInfo);
        return parkInfo.getParkId();
    }

    @Override
    @Transactional
    public void insertParkInvestmentCost(ParkInvestmentCost parkInvestmentCost) {
        parkInvestmentCostMapper.insert(parkInvestmentCost);
    }

    @Override
    @Transactional
    public void insertParkMerchant(ParkMerchant parkMerchant) {
        parkMerchantMapper.insert(parkMerchant);
    }

    @Override
    @Transactional
    public void insertParkResource(ParkResource parkResource) {
        parkResourceMapper.insert(parkResource);
    }

    @Override
    @Transactional
    public void insertParkCompany(List<ParkCompany> parkCompanyList) {
        parkCompanyMapper.insertParkCompany(parkCompanyList);
    }

    @Override
    @Transactional
    public void insertParkEnvironment(List<ParkEnvironment> parkEnvironmentList) {
        parkEnvironmentMapper.insertParkEnvironment(parkEnvironmentList);
    }

    @Override
    @Transactional
    public void updateParkInfo(ParkInfo parkInfo) {
        parkInfoMapper.updateById(parkInfo);
    }

    @Override
    @Transactional
    public void updateParkInvestmentCost(ParkInvestmentCost parkInvestmentCost) {
        parkInvestmentCostMapper.updateById(parkInvestmentCost);
    }

    @Override
    @Transactional
    public void updateParkMerchant(ParkMerchant parkMerchant) {
        parkMerchantMapper.updateById(parkMerchant);
    }

    @Override
    @Transactional
    public void updateParkResource(ParkResource parkResource) {
        parkResourceMapper.updateById(parkResource);
    }

    @Override
    @Transactional
    public void updateParkCompany(List<ParkCompany> parkCompanyList) {
        Map<Integer,ParkCompany> insertMap=new HashMap<>();
        Map<Integer,ParkCompany> updateMap=new HashMap<>();
        List<ParkCompany> insertList=new ArrayList<>();
        List<ParkCompany> deleteList=new ArrayList<>();
        List<ParkCompany> updateList=new ArrayList<>();
        List<ParkCompany> selectList= parkCompanyMapper.selectList(new QueryWrapper<ParkCompany>().eq("park_id", parkCompanyList.get(0).getParkId()));
        for(ParkCompany parkCompany:parkCompanyList){
            insertMap.put(parkCompany.getCompanyNo(),parkCompany);
        }
        for(ParkCompany selectParkCompany:selectList){
            if(insertMap.containsKey(selectParkCompany.getCompanyNo())){
                updateMap.put(selectParkCompany.getCompanyNo(),insertMap.get(selectParkCompany.getCompanyNo()));
            }else {
                deleteList.add(selectParkCompany);
            }
        }
        updateList.addAll(insertMap.values());
        for(ParkCompany parkCompany:updateList){
            insertMap.remove(parkCompany.getCompanyNo());
        }
        insertList.addAll(insertMap.values());
        parkCompanyMapper.updateParkCompany(updateList);
        parkCompanyMapper.insertParkCompany(insertList);
        parkCompanyMapper.deleteParkCompany(deleteList);
    }

    @Override
    @Transactional
    public void updateParkEnvironment(List<ParkEnvironment> parkEnvironmentList) {
        parkEnvironmentMapper.updateParkEnvironment(parkEnvironmentList);
    }

    @Override
    public List getSelect(ParkRequest parkRequest) {
//        switch (parkRequest.getPhase()){
//            case "COMPANY_TYPE": case "PARK_TYPE":
//                return dictDefMapper.selectList(new QueryWrapper<DictDef>().eq("dict_id", parkRequest.getPhase()));
//            case "CHAIN":
//                List<DictIndustryChain> dictChains = dictIndustryChainMapper.selectList(new QueryWrapper<DictIndustryChain>().eq("chain_level", "0"));
//                ParkInfo parkInfoResult = parkInfoMapper.selectOneParkInfo(parkRequest.getParkId());
//                List<UnitModel> unitModelList=new ArrayList<>();
//                for(DictIndustryChain dictIndustryChain:dictChains){
//                    UnitModel unitModel=new UnitModel();
//                    unitModel.setCode(dictIndustryChain.getChainCode());
//                    unitModel.setName(dictIndustryChain.getChainName());
//                    if(parkInfoResult!=null&&parkInfoResult.getChainCode()!=null&&parkInfoResult.getChainCode().contains(dictIndustryChain.getChainCode())) unitModel.setSelected("Y");
//                    unitModelList.add(unitModel);
//                }
//                return unitModelList;
//            case "COMPANY_INDUSTRY":
//                return parkInfoMapper.selectIndustry();
//            case "PARK_INDUSTRY_TYPE":
//                List<DictDef> dictDefs = dictDefMapper.selectList(new QueryWrapper<DictDef>().eq("dict_id", parkRequest.getPhase()));
//                ParkInfo parkInfo = parkInfoMapper.selectOneParkInfo(parkRequest.getParkId());
//                List<UnitModel> unitModels=new ArrayList<>();
//                    for (DictDef dictDef:dictDefs){
//                        UnitModel unitModel=new UnitModel();
//                        unitModel.setCode(dictDef.getDictCode());
//                        unitModel.setName(dictDef.getCodeName());
//                        if (parkInfo!=null&&parkInfo.getParkLeadingIndustry()!=null&&parkInfo.getParkLeadingIndustry().contains(dictDef.getCodeName())){
//                            unitModel.setSelected("Y");
//                        }
//                        unitModels.add(unitModel);
//                    }
//                return unitModels;
//            default:
//                return null;
//        }
        return  null;

    }
}
