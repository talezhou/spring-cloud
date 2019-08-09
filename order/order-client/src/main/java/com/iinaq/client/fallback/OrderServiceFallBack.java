package com.iinaq.client.fallback;

import com.iinaq.api.vo.req.OrderNoReqVO;
import com.iinaq.api.vo.res.OrderNoResVO;
import com.iinaq.client.api.OrderServiceClient;
import com.iinaq.common.enums.StatusEnum;
import com.iinaq.common.res.BaseResponse;
import org.springframework.web.bind.annotation.RequestBody;

public class OrderServiceFallBack implements OrderServiceClient {
    @Override
    public BaseResponse<OrderNoResVO> getOrderNo(@RequestBody OrderNoReqVO orderNoReq) {
        BaseResponse<OrderNoResVO> baseResponse = new BaseResponse<>() ;
        OrderNoResVO vo = new OrderNoResVO() ;
        vo.setOrderId(123456L);
        baseResponse.setDataBody(vo);
        baseResponse.setMessage(StatusEnum.FALLBACK.getMessage());
        baseResponse.setCode(StatusEnum.FALLBACK.getCode());
        return baseResponse;
    }
}
