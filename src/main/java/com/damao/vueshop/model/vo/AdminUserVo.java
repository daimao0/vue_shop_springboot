package com.damao.vueshop.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 *
 * 管理员登录成功后返回的参数
 * @author 呆毛
 */

@ApiModel(value = "管理员登录后返回的用户参数")
@Data
@Accessors(chain = true)
public class AdminUserVo {

    @ApiModelProperty(value = "管理员id")
    private Long id;

    @ApiModelProperty(value = "用户昵称")
    private String nickname;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "角色")
    private String role;

    @ApiModelProperty(value = "jwt令牌")
    private String token;


}
