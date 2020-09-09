package com.damao.vueshop.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.damao.vueshop.mapper.AdminUserDao;
import com.damao.vueshop.model.AdminUser;
import com.damao.vueshop.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
