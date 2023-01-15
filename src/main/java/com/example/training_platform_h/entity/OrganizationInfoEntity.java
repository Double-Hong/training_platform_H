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
 * @author Double-Hong
 * @since 2023-01-15 16:01:20
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("organization_info")
@ApiModel(value = "OrganizationInfoEntity对象", description = "")
public class OrganizationInfoEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("`name`")
    private String name;

    @TableField("phone")
    private String phone;

    @TableField("email")
    private String email;


}
