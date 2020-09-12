package com.damao.vueshop.service.impl;

import cn.hutool.core.convert.Convert;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.damao.vueshop.common.api.CommonPage;
import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.mapper.AdminUserDao;
import com.damao.vueshop.model.AdminUser;
import com.damao.vueshop.service.AdminUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 呆毛
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserDao, AdminUser> implements AdminUserService {
    @Autowired
    AdminUserDao adminUserDao;

    @Override
    public AdminUser getAdminUserById(Long id) {
        AdminUser adminUserCondition = new AdminUser();
        adminUserCondition.setId(id);
        AdminUser adminUser = adminUserDao.selectOne(adminUserCondition);
        if (adminUser.getStatus()==1){
            return adminUser;
        }
        return null;
    }

    @Override
    public AdminUser getAdminUserByMobile(String mobile) {
        AdminUser adminUserCondition = new AdminUser();
        adminUserCondition.setMobile(mobile);
        AdminUser adminUser = adminUserDao.selectOne(adminUserCondition);
        if (adminUser.getStatus()==1){
            return adminUser;
        }
        return null;
    }

    @Override
    public CommonResult<CommonPage<AdminUser>> listAdminUsers(String query, String pageNum, String pageSize) {
        List<AdminUser> listAdminUsers = adminUserDao.selectList(null);
        CommonPage<AdminUser> adminUserCommonPages = CommonPage.restPage(listAdminUsers);
        adminUserCommonPages.setPageNum(Convert.toInt(pageNum));
        adminUserCommonPages.setPageSize(Convert.toInt(pageSize));
        return CommonResult.success(adminUserCommonPages,"获取成功");
    }
}
