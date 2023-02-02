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
@TableName("examination_and_multiple_choice")
@ApiModel(value = "ExaminationAndMultipleChoiceEntity对象", description = "")
public class ExaminationAndMultipleChoiceEntity {

    @TableField("examination_id")
    private String examinationId;

    @TableField("multiple_choice_id")
    private String multipleChoiceId;

    @TableField("answer")
    private String answer;

    @TableField("fraction")
    private String fraction;


}
