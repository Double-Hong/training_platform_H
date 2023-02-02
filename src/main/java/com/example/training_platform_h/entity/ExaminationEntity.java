package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
 * @since 2023-01-30 21:28:52
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("examination")
@ApiModel(value = "ExaminationEntity对象", description = "")
public class ExaminationEntity {

    @TableId(value = "examination_id", type = IdType.AUTO)
    private String examinationId;

    @TableField("examination_name")
    private String examinationName;

    @TableField("examination_open_time")
    private LocalDateTime examinationOpenTime;

    @TableField("examination_close_time")
    private LocalDateTime examinationCloseTime;

    @TableField("examination_time")
    private LocalTime examinationTime;

    @TableField("organization_id")
    private String organizationId;


}
