package com.damao.vueshop.service;

import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.model.dto.AdminUserDto;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * 管理员登录
 * @author 呆毛
 */
public interface AdminUserLoginService {
    /**
     * 账号密码登录
     * @param mobile 管理员手机号
     * @param password 密码
     * @param httpServletResponse 服务器响应
     * @return
     */
    CommonResult<AdminUserDto> loginUsePassword(String mobile,String password,
                                                HttpServletResponse httpServletResponse);
}
