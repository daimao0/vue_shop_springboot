package com.damao.vueshop.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 呆毛
 */

@Data
@TableName(value = "admin_user")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class AdminUser implements Serializable {
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "id",type = IdType.AUTO)   //指定自增策略
    private Long id;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "email")
    private String email;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "role")
    private String role;

    @TableField(value = "password")
    private String password;

    @TableField(value = "status")
    private Integer status;
}
