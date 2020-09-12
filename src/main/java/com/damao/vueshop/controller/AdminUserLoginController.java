package com.damao.vueshop.controller;

import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.model.dto.AdminUserDto;
import com.damao.vueshop.service.AdminUserLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户登录模块
 * @author 呆毛
 */
@RestController
@Api(tags = "AdminUserLoginController",description = "会员登录模块")
public class AdminUserLoginController {

    @Autowired
    AdminUserLoginService adminUserLoginService;

    @PostMapping("/login")
    @ApiOperation(value = "账号密码登录")
    public CommonResult<AdminUserDto> loginUsePassword(@RequestBody Map<String,String> map,
                                                       HttpServletResponse httpServletResponse){
        String mobile = map.get("mobile");
        String password = map.get("password");
        return adminUserLoginService.loginUsePassword(mobile,password,httpServletResponse);
    }

}
