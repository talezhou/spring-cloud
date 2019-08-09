package com.iinaq.userapi.api;

import com.iinaq.userapi.vo.req.UserReqVO;
import com.iinaq.orderapi.vo.res.OrderNoResVO;
import com.iinaq.userapi.vo.res.UserResVO;
import com.iinaq.common.res.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Function:
 *
 * @since JDK 1.8
 */
@RestController
@Api("用户服务API")
@RequestMapping(value = "/userService")
@Validated
public interface UserService {


    /**
     * 获取用户
     * @param userReqVO
     * @return
     */
    @ApiOperation("获取用户")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    BaseResponse<UserResVO> getOrderNo(@RequestBody UserReqVO userReqVO) ;

    /**
     * 通过Feign获取用户
     * @param userReqVO
     * @return
     */
    @ApiOperation("通过Feign获取用户")
    @RequestMapping(value = "/getUserByFeign", method = RequestMethod.POST)
    BaseResponse<UserResVO> getUserByFeign(@RequestBody UserReqVO userReqVO) ;


    /**
     * 批量请求接口
     * @param userReqVO
     * @return
     */
    @ApiOperation("批量请求接口")
    @RequestMapping(value = "/getUserByFeignBatch", method = RequestMethod.POST)
    BaseResponse<UserResVO> getUserByFeignBatch(@RequestBody UserReqVO userReqVO) ;

    /**
     * hystrix容错调用
     * @param userReqVO
     * @return
     */
    @ApiOperation("hystrix容错调用")
    @RequestMapping(value = "/getUserByHystrix", method = RequestMethod.POST)
    BaseResponse<OrderNoResVO> getUserByHystrix(@RequestBody UserReqVO userReqVO) ;
}
