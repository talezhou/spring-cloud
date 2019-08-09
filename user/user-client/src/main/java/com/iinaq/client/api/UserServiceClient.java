package com.iinaq.client.api;

import com.iinaq.userapi.api.UserService;
import com.iinaq.userapi.vo.req.UserReqVO;
import com.iinaq.orderapi.vo.res.OrderNoResVO;
import com.iinaq.userapi.vo.res.UserResVO;
import com.iinaq.common.res.BaseResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/7/16 19:00
 * @since JDK 1.8
 */
@RequestMapping(value="/userService")
@FeignClient(name="sbc-user")
//@RibbonClient
public interface UserServiceClient extends UserService {


    @ApiOperation("获取用户")
    @RequestMapping(value = "/getOrderNo", method = RequestMethod.POST)
    BaseResponse<UserResVO> getOrderNo(@RequestBody UserReqVO orderNoReq) ;


    @ApiOperation("通过Feign获取用户")
    @RequestMapping(value = "/getUserByFeign", method = RequestMethod.POST)
    BaseResponse<UserResVO> getUserByFeign(@RequestBody UserReqVO userReqVO) ;


    @ApiOperation("批量请求接口")
    @RequestMapping(value = "/getUserByFeignBatch", method = RequestMethod.POST)
    BaseResponse<UserResVO> getUserByFeignBatch(@RequestBody UserReqVO userReqVO) ;

    @ApiOperation("hystrix容错调用")
    @RequestMapping(value = "/getUserByHystrix", method = RequestMethod.POST)
    BaseResponse<OrderNoResVO> getUserByHystrix(@RequestBody UserReqVO userReqVO) ;
}
