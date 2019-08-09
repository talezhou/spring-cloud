package com.iinaq.rest.controller;

import com.iinaq.api.api.OrderService;
import com.iinaq.api.vo.req.OrderNoReqVO;
import com.iinaq.api.vo.res.OrderNoResVO;
import com.iinaq.common.enums.StatusEnum;
import com.iinaq.common.exception.SBCException;
import com.iinaq.common.res.BaseResponse;
import com.iinaq.common.utils.DateUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Function:order控制器
 * @since JDK 1.8
 */
@RestController
@Api(value = "orderApi", description = "订单API", tags = {"订单服务"})
public class OrderController implements OrderService {
    private final static Logger LOGGER = LoggerFactory.getLogger(OrderController.class);


    @Override
    //@CheckReqNo
    public BaseResponse<OrderNoResVO> getOrderNo(@RequestBody OrderNoReqVO orderNoReq) {
        BaseResponse<OrderNoResVO> res = new BaseResponse();
        res.setReqNo(orderNoReq.getReqNo());
        if (null == orderNoReq.getAppId()){
            throw new SBCException(StatusEnum.FAIL);
        }
        OrderNoResVO orderNoRes = new OrderNoResVO() ;
        orderNoRes.setOrderId(DateUtil.getLongTime());
        res.setCode(StatusEnum.SUCCESS.getCode());
        res.setMessage(StatusEnum.SUCCESS.getMessage());
        res.setDataBody(orderNoRes);
        return res ;
    }
}