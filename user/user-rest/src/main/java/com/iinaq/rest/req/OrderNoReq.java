package com.iinaq.rest.req;

import com.iinaq.common.req.BaseRequest;

public class OrderNoReq extends BaseRequest {
    private String appId ;//应用ID

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }
}
