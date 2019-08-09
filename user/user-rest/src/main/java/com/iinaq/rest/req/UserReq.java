package com.iinaq.rest.req;

import com.iinaq.common.req.BaseRequest;

public class UserReq extends BaseRequest {
    private long userId ;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
