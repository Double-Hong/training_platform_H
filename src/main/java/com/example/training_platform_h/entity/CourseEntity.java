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
 * @since 2023-01-15 11:31:10
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("course")
@ApiModel(value = "CourseEntity对象", description = "")
public class CourseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("`name`")
    private String name;

    @TableField("`description`")
    private String description;


}
