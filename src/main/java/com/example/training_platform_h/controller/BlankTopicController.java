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
import java.util.Objects;
import java.util.UUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Double-Hong
 * @since 2023-01-30 21:28:52
 */
@RestController
@RequestMapping("/blank-topic-entity")
public class BlankTopicController {

    @Autowired
    BlankTopicMapper blankTopicMapper;

    @Autowired
    ExaminationAndBlankTopicMapper examinationAndBlankTopicMapper;

    @GetMapping("/getBlankInfoByExamId/{examId}")
    public List<BlankTopicEntity> getBlankInfoByExamId(@PathVariable String examId) {
        List<BlankTopicEntity> allBlankTopicEntity = blankTopicMapper.selectList(null);
        List<ExaminationAndBlankTopicEntity> info = examinationAndBlankTopicMapper.selectList(Wrappers.<ExaminationAndBlankTopicEntity>lambdaQuery().eq(ExaminationAndBlankTopicEntity::getExaminationId, examId));
        List<BlankTopicEntity> hadBlankTopicEntity = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            hadBlankTopicEntity.add(i, blankTopicMapper.selectById(info.get(i).getBlankTopicId()));
        }
        for (int i = 0; i < hadBlankTopicEntity.size(); i++) {
            for (int j = 0; j < allBlankTopicEntity.size(); j++) {
                if (Objects.equals(hadBlankTopicEntity.get(i).getBlankTopicId(), allBlankTopicEntity.get(j).getBlankTopicId())) {
                    allBlankTopicEntity.remove(allBlankTopicEntity.get(j));
                }
            }
        }
        return allBlankTopicEntity;
    }

    @GetMapping("/findBlank/{examId},{search}")//搜寻填空题
    public List<BlankTopicEntity> findBlank(@PathVariable String examId, @PathVariable String search) {
        List<BlankTopicEntity> allBlankTopicEntity = blankTopicMapper.selectList(new QueryWrapper<BlankTopicEntity>().like("blank_topic_describe", search)
                .or().like("correct_answer", search));
        List<ExaminationAndBlankTopicEntity> info = examinationAndBlankTopicMapper.selectList(Wrappers.<ExaminationAndBlankTopicEntity>lambdaQuery().eq(ExaminationAndBlankTopicEntity::getExaminationId, examId));
        List<BlankTopicEntity> hadBlankTopicEntity = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            hadBlankTopicEntity.add(i, blankTopicMapper.selectById(info.get(i).getBlankTopicId()));
        }
        for (int i = 0; i < hadBlankTopicEntity.size(); i++) {
            for (int j = 0; j < allBlankTopicEntity.size(); j++) {
                if (Objects.equals(hadBlankTopicEntity.get(i).getBlankTopicId(), allBlankTopicEntity.get(j).getBlankTopicId())) {
                    allBlankTopicEntity.remove(allBlankTopicEntity.get(j));
                }
            }
        }
        return allBlankTopicEntity;
    }


    @GetMapping("/getAllBlank")//获取所有填空题信息
    public List<BlankTopicEntity> getAllBlank() {
        return blankTopicMapper.selectList(null);
    }

    @PostMapping("/editBlankById")//修改填空题并返回新数据
    public List<BlankTopicEntity> editBlankById(@RequestBody BlankTopicEntity blankTopicEntity) {
        blankTopicMapper.updateById(blankTopicEntity);
        return blankTopicMapper.selectList(null);
    }

    @GetMapping("/deleteBlankById/{blankId}")//删除填空题信息并返回数据
    public List<BlankTopicEntity> deleteBlankById(@PathVariable String blankId) {
        blankTopicMapper.deleteById(blankId);
        return blankTopicMapper.selectList(null);
    }

    @PostMapping("/addBlank")//新增填空题并返回新数据
    public List<BlankTopicEntity> addBlank(@RequestBody BlankTopicEntity blankTopicEntity) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        blankTopicEntity.setBlankTopicId(id);
        blankTopicMapper.insert(blankTopicEntity);
        return blankTopicMapper.selectList(null);
    }

    @GetMapping("/findBlankAll/{search}")
    public List<BlankTopicEntity> findBlankAll(@PathVariable String search) {
        return blankTopicMapper.selectList(new QueryWrapper<BlankTopicEntity>().like("blank_topic_describe", search)
                .or().like("correct_answer", search));
    }
}
