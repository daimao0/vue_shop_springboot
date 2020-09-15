package com.damao.vueshop.service;

import com.damao.vueshop.common.api.CommonPage;
import com.damao.vueshop.common.api.CommonResult;
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
     * @param mobile 手机号
     * @return
     */
    AdminUser getAdminUserByMobile(String mobile);

    /**
     * 获取管理员列表
     * @param pageNum 当前页码
     * @param pageSize 每页显示条数
     * @param query 查询参数
     * @return
     */
    CommonResult<CommonPage<AdminUser>> listAdminUsers(String query, String pageNum, String pageSize);

    /**
     *添加用户
     * @param username 用户名称
     * @param password 用户密码
     * @param email 邮箱
     * @param mobile 手机号
     * @return
     */
    CommonResult<AdminUser> addAdminUser (String username, String password, String email, String mobile);

    /**修改用户状态
     * @param id 用户id
     * @param type 用户状态
     */
    CommonResult<AdminUser> updateAdminUserType(Long id,Integer type);
}
