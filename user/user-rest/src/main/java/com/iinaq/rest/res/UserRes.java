package com.iinaq.rest.res;


import com.iinaq.common.res.BaseResponse;

/**
 * Function:
 *
 * @since JDK 1.8
 */
public class UserRes extends BaseResponse {
    private long userId ;
    private String userName ;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "UserRes{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
