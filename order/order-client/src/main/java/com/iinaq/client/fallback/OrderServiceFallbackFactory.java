package com.iinaq.client.fallback;

import com.iinaq.api.vo.req.OrderNoReqVO;
import com.iinaq.api.vo.res.OrderNoResVO;
import com.iinaq.client.api.OrderServiceClient;
import com.iinaq.common.enums.StatusEnum;
import com.iinaq.common.res.BaseResponse;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Function:查看fallback原因
 *
 * @since JDK 1.8
 */
public class OrderServiceFallbackFactory implements FallbackFactory<OrderServiceClient> {

    private final static Logger LOGGER = LoggerFactory.getLogger(OrderServiceFallbackFactory.class);


    @Override
    public OrderServiceClient create(Throwable throwable) {

        return new OrderServiceClient() {
            @Override
            public BaseResponse<OrderNoResVO> getOrderNo(@RequestBody OrderNoReqVO orderNoReq) {
                LOGGER.error("fallback:" + throwable);

                BaseResponse<OrderNoResVO> baseResponse = new BaseResponse<>() ;
                OrderNoResVO vo = new OrderNoResVO() ;
                vo.setOrderId(123456L);
                baseResponse.setDataBody(vo);
                baseResponse.setMessage(StatusEnum.FALLBACK.getMessage());
                baseResponse.setCode(StatusEnum.FALLBACK.getCode());
                return baseResponse;
            }
        };
    }
}