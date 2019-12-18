package com.ceic.park.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : luofeng
 * @date : Created in 2019/8/30 14:21
 * @description :
 */
@Data
@ApiModel(value = "抽象请求参数实体")
public abstract class BaseRequest{

    @ApiModelProperty(value = "当前页")
    private int currentPage = 1;

    @ApiModelProperty(value = "页长")
    private int pageSize = 10;

    @ApiModelProperty(value = "区域级别")
    private String regionLevel;

    @ApiModelProperty(value = "区域编码")
    private String regionCode;

    public Map<String,Object> buildMaps(){
        Map<String,Object> params = new HashMap<>();
        params.put("regionLevel",StringUtils.isBlank(this.regionLevel)?null:this.regionLevel);
        params.put("regionCode",StringUtils.isBlank(this.regionCode)?null:this.regionCode);
        return params;
    }
}
