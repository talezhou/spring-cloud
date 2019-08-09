package com.iinaq.api.vo.req;

import com.iinaq.common.req.BaseRequest;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class OrderNoReqVO extends BaseRequest {

    @NotNull(message = "应用ID不能为空")
    @ApiModelProperty(required = true, value = "应用ID", example = "00100")
    private Long appId ;//应用ID

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
}
