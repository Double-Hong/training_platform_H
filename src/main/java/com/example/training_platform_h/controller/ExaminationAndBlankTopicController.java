package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.BlankTopicEntity;
import com.example.training_platform_h.entity.ExaminationAndBlankTopicEntity;
import com.example.training_platform_h.mapper.BlankTopicMapper;
import com.example.training_platform_h.mapper.ExaminationAndBlankTopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
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
    public List<BlankTopicEntity> getAllBlankTopicById(@PathVariable String id) {

        List<ExaminationAndBlankTopicEntity> info = examinationAndBlankTopicMapper.selectList(Wrappers.<ExaminationAndBlankTopicEntity>lambdaQuery().eq(ExaminationAndBlankTopicEntity::getExaminationId, id));
        List<BlankTopicEntity> result = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            result.add(i, blankTopicMapper.selectById(info.get(i).getBlankTopicId()));

        }
        return result;
    }

    @GetMapping("getAllBlankById/{eid}")//获得所有的题目分数信息
    public List<ExaminationAndBlankTopicEntity> getAllBlankById(@PathVariable String eid) {
        return examinationAndBlankTopicMapper.selectList(Wrappers.<ExaminationAndBlankTopicEntity>lambdaQuery().eq(ExaminationAndBlankTopicEntity::getExaminationId, eid));
    }

    @GetMapping("/deleteOneBlank/{examId},{blankId}")//删除考试中的一个填空题题目
    public int deleteOneBlank(@PathVariable String examId, @PathVariable String blankId) {
        return examinationAndBlankTopicMapper.delete(new QueryWrapper<ExaminationAndBlankTopicEntity>().eq("examination_id", examId)
                .eq("blank_topic_id", blankId));
    }

    @GetMapping("/modifyBlankFraction/{examId},{blankId},{fraction}")//修改填空的分值
    public int modifyBlankFraction(@PathVariable String examId, @PathVariable String fraction, @PathVariable String blankId) {
        ExaminationAndBlankTopicEntity examinationAndBlankTopicEntity = examinationAndBlankTopicMapper.selectOne(new QueryWrapper<ExaminationAndBlankTopicEntity>().eq("examination_id", examId)
                .eq("blank_topic_id", blankId));
        examinationAndBlankTopicEntity.setFraction(fraction);
        return examinationAndBlankTopicMapper.update(examinationAndBlankTopicEntity, new QueryWrapper<ExaminationAndBlankTopicEntity>().eq("examination_id", examId)
                .eq("blank_topic_id", blankId));
    }

    @PostMapping("/addOneBlank")//添加一个填空题
    public int addOneBlank(@RequestBody ExaminationAndBlankTopicEntity examinationAndBlankTopicEntity) {
        return examinationAndBlankTopicMapper.insert(examinationAndBlankTopicEntity);
    }
}
