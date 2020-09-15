package com.damao.vueshop.controller;

import com.damao.vueshop.common.api.CommonPage;
import com.damao.vueshop.common.api.CommonResult;
import com.damao.vueshop.model.AdminUser;
import com.damao.vueshop.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public CommonResult<CommonPage<AdminUser>> listAdminUsers(@RequestBody @ApiParam(value = "传入query、Pagenum、pagesize") Map<String, String> map) {
        String query = map.get("query");
        String pageNum = map.get("pagenum");
        String pageSize = map.get("pagesize");
        return adminUserService.listAdminUsers(query,pageNum,pageSize);
    }

    @PostMapping("/users")
    @ApiOperation(value = "添加用户")
    public CommonResult<AdminUser> addAdminUser(@RequestBody @ApiParam(value = "传入username、password、Email、mobile") Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        String email = map.get("email");
        String mobile = map.get("mobile");
        return adminUserService.addAdminUser(username,password,email,mobile);
    }

    @PutMapping("/users/{uId}/{type}")
    @ApiOperation(value = "修改用户状态")
    public CommonResult<AdminUser> updateAdminUserType(@ApiParam(value = "传入 uId、type") @PathVariable(value = "uId") Long uId,@PathVariable(value = "type") Integer type){
        Long id = uId;
        return adminUserService.updateAdminUserType(id,type);
    }
}
