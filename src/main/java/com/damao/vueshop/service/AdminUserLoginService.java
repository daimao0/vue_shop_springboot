package com.damao.vueshop.service;

import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.model.vo.AdminUserLoginVo;
import com.damao.vueshop.model.vo.AdminUserVo;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * 管理员登录
 * @author 呆毛
 */
public interface AdminUserLoginService {
    /**
     * 账号密码登录
     * @param adminUserLoginVo 管理员
     * @param httpServletResponse 服务器响应
     * @return
     */
    CommonResult<AdminUserVo> loginUsePassword(AdminUserLoginVo adminUserLoginVo,
                                               HttpServletResponse httpServletResponse);
}
