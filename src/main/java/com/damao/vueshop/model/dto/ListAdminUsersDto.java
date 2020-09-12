package com.damao.vueshop.model.dto;

import com.damao.vueshop.model.AdminUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 获取管理员用户数据列表
 * @author 呆毛
 */
@ApiModel(value = "管理员列表模型")
@Data
@Accessors(chain = true)
public class ListAdminUsersDto implements Serializable {
    @ApiModelProperty(value = "总记录数")
    private String totalPage;
    @ApiModelProperty(value = "当前页码")
    private String pageNum;
    @ApiModelProperty(value = "管理员结果集")
    private List<AdminUser>  listAdminUsers;
}
