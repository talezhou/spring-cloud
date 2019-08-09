package com.iinaq.client.api;

import com.iinaq.orderapi.api.OrderService;
import com.iinaq.orderapi.vo.req.OrderNoReqVO;
import com.iinaq.orderapi.vo.res.OrderNoResVO;
import com.iinaq.client.config.OrderConfig;
import com.iinaq.client.fallback.OrderServiceFallbackFactory;
import com.iinaq.common.res.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value="/orderService")
@FeignClient(name="sbc-order",
        fallbackFactory = OrderServiceFallbackFactory.class,
        // FIXME: 2017/9/4 如果配置了fallback 那么fallbackFactory将会无效
        //fallback = OrderServiceFallBack.class,
        configuration = OrderConfig.class)
@RibbonClient
public interface OrderServiceClient extends OrderService {


    @ApiOperation("获取订单号")
    @RequestMapping(value = "/getOrderNo", method = RequestMethod.POST)
    BaseResponse<OrderNoResVO> getOrderNo(@RequestBody OrderNoReqVO orderNoReq) ;
}
