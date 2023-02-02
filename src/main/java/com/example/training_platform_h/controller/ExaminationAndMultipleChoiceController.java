package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.ExaminationAndMultipleChoiceEntity;
import com.example.training_platform_h.entity.MultipleChoiceEntity;
import com.example.training_platform_h.mapper.ExaminationAndMultipleChoiceMapper;
import com.example.training_platform_h.mapper.MultipleChoiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong
 * @since 2023-01-30 21:28:52
 */
@RestController
@RequestMapping("/examination-and-multiple-choice-entity")
public class ExaminationAndMultipleChoiceController {
   @Autowired
   ExaminationAndMultipleChoiceMapper examinationAndMultipleChoiceMapper;
   @Autowired
    MultipleChoiceMapper multipleChoiceMapper;
   @GetMapping("getAllMultipleById/{eid}")//根据eid得到所有的选择题
    public List<MultipleChoiceEntity> getAllMultipleById(@PathVariable String eid){
       List<ExaminationAndMultipleChoiceEntity> info = examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId,eid));
       List<MultipleChoiceEntity> result = new ArrayList<>();
       for (int i=0;i<info.size();i++){
           result.add(i,multipleChoiceMapper.selectById(info.get(i).getMultipleChoiceId()));
       }
       return result;
   }
   @GetMapping("getFractionById/{eid},{bid}")
    public String getFractionById(@PathVariable String eid ,@PathVariable String bid){
       return examinationAndMultipleChoiceMapper.selectOne(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId,eid).eq(ExaminationAndMultipleChoiceEntity::getMultipleChoiceId,bid)).getFraction();

   }
   @GetMapping("getAllchoiceInfoByEid/{eid}")
    public List<ExaminationAndMultipleChoiceEntity>getAllchoiceInfoByEid(@PathVariable String eid){
       return examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId,eid));
   }
}
