package com.damao.vueshop.service.impl;

import cn.hutool.core.convert.Convert;
import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.common.utils.JwtTokenUtil;
import com.damao.vueshop.model.AdminUser;
import com.damao.vueshop.model.vo.AdminUserLoginVo;
import com.damao.vueshop.model.vo.AdminUserVo;
import com.damao.vueshop.service.AdminUserLoginService;
import com.damao.vueshop.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 呆毛
 */
@Service
public class AdminUserLoginServiceImpl implements AdminUserLoginService {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    AdminUserService adminUserService;

    @Override
    public CommonResult<AdminUserVo> loginUsePassword(AdminUserLoginVo adminUserLoginVo, HttpServletResponse httpServletResponse) {
        //从数据库中取出adminuser
        AdminUser adminuser = adminUserService.getAdminUserByMobile(adminUserLoginVo.getMobile());
        if (adminuser!=null && adminuser.getPassword().equals(adminUserLoginVo.getPassword())){
            AdminUserVo adminUserVo = new AdminUserVo()
                    .setId(adminuser.getId())
                    .setNickname(adminuser.getNickname())
                    .setMobile(adminuser.getMobile())
                    .setEmail(adminuser.getEmail())
                    .setRole(adminuser.getRole());
            //获取当前时间
            String currentTimeMillis = Convert.toStr(System.currentTimeMillis());

            if (adminuser.getId()==null){
                return CommonResult.failed("程序错误，请联系客服人员解决");
            }
            //生成token
            String token = jwtTokenUtil.generateToken(adminuser.getId(), currentTimeMillis);
            adminUserVo.setToken(token);
            //存储token

            httpServletResponse.setHeader("authorization",token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return CommonResult.success(adminUserVo,"登陆成功");
        }
        return CommonResult.failed("查询失败，请检查用户名密码");
    }
}
