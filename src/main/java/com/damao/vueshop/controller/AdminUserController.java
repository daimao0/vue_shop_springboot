package com.damao.vueshop.controller;

import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.model.AdminUser;
import com.damao.vueshop.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 管理员模块
 *
 * @author 呆毛
 */
@RestController
@Api(tags = "AdminUserController",description = "管理员模块")
public class AdminUserController {
    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/users")
    @ApiOperation(value = "获取用户信息")
    public CommonResult<List<AdminUser>> listAdminUsers(@RequestBody Map<String, String> map) {
        String query = map.get("query");
        String pageNum = map.get("pagenum");
        String pageSize = map.get("pagesize");
        return adminUserService.listAdminUsers(query,pageNum,pageSize);
    }
}
