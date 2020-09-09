package com.damao.vueshop.service;

import com.damao.vueshop.model.AdminUser;

/**
 * AdminUserService的业务逻辑
 * @author 呆毛
 */
public interface AdminUserService {
    /**
     * 通过表id获取AdminUser
     * @param id 传递AdminUser的id字段
     * @return
     */
    AdminUser getAdminUserById(Long id);

    /**
     * 通过用户名或者手机号查找管理员
     * @param param
     * @return
     */
    AdminUser getAdminUserByMobile(String param);
}
