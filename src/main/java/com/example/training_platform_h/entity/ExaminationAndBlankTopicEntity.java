package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
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
@TableName("examination_and_blank_topic")
@ApiModel(value = "ExaminationAndBlankTopicEntity对象", description = "")
public class ExaminationAndBlankTopicEntity {

    @TableField("examination_id")
    private String examinationId;

    @TableField("blank_topic_id")
    private String blankTopicId;

    @TableField("answer")
    private String answer;

    @TableField("fraction")
    private String fraction;

}
