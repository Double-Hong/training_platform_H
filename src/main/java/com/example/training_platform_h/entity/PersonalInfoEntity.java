package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Double-Hong and My-way
 * @since 2023-01-15 11:31:10
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("personal_info")
@ApiModel(value = "PersonalInfoEntity对象", description = "")
public class PersonalInfoEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("username")
    private String username;

    @TableField("`name`")
    private String name;

    @TableField("age")
    private Integer age;

    @TableField("sex")
    private String sex;

    @TableField("phone")
    private String phone;

    @TableField("qq")
    private String qq;

    @TableField("email")
    private String email;

    @TableField("address")
    private String address;

    @TableField("`password`")
    private String password;

    @TableField("user_type")
    private int userType;

    @TableField("organization_id")
    private String organizationId;
}
