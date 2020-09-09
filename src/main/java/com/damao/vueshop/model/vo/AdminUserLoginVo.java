package com.damao.vueshop.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 管理员登录时传输参数
 * @author 呆毛
 */
@ApiModel(value = "管理员密码登录传入参数")
@Data
public class AdminUserLoginVo {
    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "密码")
    private String password;
}
