package com.damao.vueshop.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.damao.vueshop.model.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 *  AdminUser与数据库交互
 * @author 呆毛
 */
@Mapper
public interface AdminUserDao extends BaseMapper<AdminUser> {
}
