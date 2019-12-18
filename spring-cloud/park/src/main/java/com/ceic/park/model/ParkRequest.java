package com.ceic.park.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
public class ParkRequest extends BaseRequest {

    @ApiModelProperty(value = "产业链code")
    private String chainCode;

    @ApiModelProperty(value = "园区名称")
    private String parkName;

    @ApiModelProperty(value = "园区类型")
    private String parkType;

    @ApiModelProperty(value = "状态码")
    private String phase;

    @ApiModelProperty(value = "parkId")
    private String parkId;

    public Map<String, Object> getMaps() {
        Map<String, Object> params = new HashMap<>();
        params.put("parkName", StringUtils.isBlank(this.parkName) ? null : this.parkName);
        params.put("parkType", StringUtils.isBlank(this.parkType) ? null : this.parkType);
        params.put("chainCode", StringUtils.isBlank(this.chainCode) ? null : this.chainCode);
        params.put("parkId", StringUtils.isBlank(this.parkId) ? null : this.parkId);
        params.put("phase", StringUtils.isBlank(this.phase) ? null : this.phase);
        params.putAll(this.buildMaps());
        return params;
    }
}
