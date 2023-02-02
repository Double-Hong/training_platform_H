package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.BlankTopicEntity;
import com.example.training_platform_h.entity.ExaminationAndBlankTopicEntity;
import com.example.training_platform_h.mapper.BlankTopicMapper;
import com.example.training_platform_h.mapper.ExaminationAndBlankTopicMapper;
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
@RequestMapping("/examination-and-blank-topic-entity")
public class ExaminationAndBlankTopicController {

    @Autowired
    ExaminationAndBlankTopicMapper examinationAndBlankTopicMapper;
    @Autowired
    BlankTopicMapper blankTopicMapper;
    @GetMapping("getAllBlankTopicById/{id}")//获得所有的题目的描述，正确答案等
    public List<BlankTopicEntity> getAllBlankTopicById(@PathVariable String id){

      List<ExaminationAndBlankTopicEntity> info=examinationAndBlankTopicMapper.selectList(Wrappers.<ExaminationAndBlankTopicEntity>lambdaQuery().eq(ExaminationAndBlankTopicEntity::getExaminationId,id));
       List<BlankTopicEntity> result=new ArrayList<>();
        for (int i=0;i< info.size();i++){
            result.add(i,blankTopicMapper.selectById(info.get(i).getBlankTopicId()));

        }
        return result;
    }
    @GetMapping("getAllBlankById/{eid}")//获得所有的题目分数信息
    public List<ExaminationAndBlankTopicEntity>getAllBlankById(@PathVariable String eid){
        return examinationAndBlankTopicMapper.selectList(Wrappers.<ExaminationAndBlankTopicEntity>lambdaQuery().eq(ExaminationAndBlankTopicEntity::getExaminationId,eid));
    }
}
