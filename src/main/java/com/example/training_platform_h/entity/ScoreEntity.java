package com.example.training_platform_h.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
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
@TableName("score")
@ApiModel(value = "ScoreEntity对象", description = "")
public class ScoreEntity {

    @TableField("examination_id")
    private String examinationId;

    @TableField("person_info_id")
    private String personInfoId;

    @TableField("score")
    private BigDecimal score;


}
