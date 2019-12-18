package com.ceic.park.biz;



import com.ceic.park.model.*;
import com.ceic.park.model.park.*;

import java.util.List;

public interface ParkBizService {
    Result<List<ParkInfo>> selectParkInfo(ParkRequest parkRequest);

    ParkInfo selectOnePark(String parkId);

    void deleteParkInfo(List<ParkInfo> parkInfos);

    int insertParkInfo(ParkInfo parkInfo);

    void insertParkInvestmentCost(ParkInvestmentCost parkInvestmentCost);

    void insertParkMerchant(ParkMerchant parkMerchant);

    void insertParkResource(ParkResource parkResource);

    void insertParkCompany(List<ParkCompany> parkCompanyList);

    void insertParkEnvironment(List<ParkEnvironment> parkEnvironmentList);

    void updateParkInfo(ParkInfo parkInfo);

    void updateParkInvestmentCost(ParkInvestmentCost parkInvestmentCost);

    void updateParkMerchant(ParkMerchant parkMerchant);

    void updateParkResource(ParkResource parkResource);

    void updateParkCompany(List<ParkCompany> parkCompanyList);

    void updateParkEnvironment(List<ParkEnvironment> parkEnvironmentList);

    List getSelect(ParkRequest parkRequest);
}
