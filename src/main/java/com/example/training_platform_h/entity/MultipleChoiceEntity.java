package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
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
 * @since 2023-01-30 21:28:52
 */
@Data
@Getter
@Setter
@Accessors(chain = true)
@TableName("multiple_choice")
@ApiModel(value = "MultipleChoiceEntity对象", description = "")
public class MultipleChoiceEntity {

    @TableId(value = "multiple_choice_id", type = IdType.AUTO)
    private String multipleChoiceId;

    @TableField("multiple_choice_describe")
    private String multipleChoiceDescribe;

    @TableField("option1")
    private String option1;

    @TableField("option2")
    private String option2;

    @TableField("option3")
    private String option3;

    @TableField("option4")
    private String option4;


    @TableField("correct_answer")
    private String correctAnswer;



}
