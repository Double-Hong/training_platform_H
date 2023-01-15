package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@Getter
@Setter
@Accessors(chain = true)
@TableName("course_ship")
@ApiModel(value = "CourseShipEntity对象", description = "")
public class CourseShipEntity {

    @TableField("per_id")
    private String perId;

    @TableField("cou_id")
    private String couId;


}
