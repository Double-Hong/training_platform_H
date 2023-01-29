package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-01-29 11:41:26
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("train_info")
@ApiModel(value = "TrainInfoEntity对象", description = "")
public class TrainInfoEntity {

    @TableId(value = "id", type = IdType.AUTO)
    private String id;

    @TableField("training_objectives")
    private String trainingObjectives;

    @TableField("training_content")
    private String trainingContent;

    @TableField("training_scoring_criteria")
    private String trainingScoringCriteria;

    @TableField("organization_id")
    private String organizationId;


}
