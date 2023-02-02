package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("blank_topic")
@ApiModel(value = "BlankTopicEntity对象", description = "")
public class BlankTopicEntity {

    @TableId(value = "blank_topic_id", type = IdType.AUTO)
    private String blankTopicId;



    @TableField("blank_topic_describe")
    private String blankTopicDescribe;


    @TableField("correct_answer")
    private String correctAnswer;



}
