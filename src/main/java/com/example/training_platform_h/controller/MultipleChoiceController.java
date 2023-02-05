package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.ExaminationAndMultipleChoiceEntity;
import com.example.training_platform_h.entity.MultipleChoiceEntity;
import com.example.training_platform_h.mapper.ExaminationAndMultipleChoiceMapper;
import com.example.training_platform_h.mapper.MultipleChoiceMapper;
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
@RequestMapping("/multiple-choice-entity")
public class MultipleChoiceController {

    @Autowired
    MultipleChoiceMapper multipleChoiceMapper;

    @Autowired
    ExaminationAndMultipleChoiceMapper examinationAndMultipleChoiceMapper;

    @GetMapping("/getAllChoiceInfo")//获取全部选择题
    public List<MultipleChoiceEntity> getAllChoiceInfo() {
        return multipleChoiceMapper.selectList(null);
    }

    @GetMapping("/getChoiceInfoByExamId/{examId}")//根据考试ID获得除已选的选择题外的选择题(添加选择题时展示)
    public List<MultipleChoiceEntity> getChoiceInfoByExamId(@PathVariable String examId) {
        List<MultipleChoiceEntity> allMultipleChoiceEntity = multipleChoiceMapper.selectList(null);
        List<ExaminationAndMultipleChoiceEntity> info = examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId, examId));
        List<MultipleChoiceEntity> hadMultipleChoiceEntity = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            hadMultipleChoiceEntity.add(i, multipleChoiceMapper.selectById(info.get(i).getMultipleChoiceId()));
        }
        for (int i = 0; i < hadMultipleChoiceEntity.size(); i++) {
            for (int j = 0; j < allMultipleChoiceEntity.size(); j++) {
                if (Objects.equals(hadMultipleChoiceEntity.get(i).getMultipleChoiceId(), allMultipleChoiceEntity.get(j).getMultipleChoiceId())) {
                    allMultipleChoiceEntity.remove(allMultipleChoiceEntity.get(j));
                }
            }
        }
        return allMultipleChoiceEntity;
    }

    //搜索选择题
    @GetMapping("/findChoice/{search},{examId}")
    public List<MultipleChoiceEntity> findChoice(@PathVariable String search, @PathVariable String examId) {
        List<MultipleChoiceEntity> allMultipleChoiceEntity = multipleChoiceMapper.selectList(new QueryWrapper<MultipleChoiceEntity>().like("multiple_choice_describe", search)
                .or().like("option1", search).or().like("option2", search).or().like("option3", search)
                .or().like("option4", search));
        List<ExaminationAndMultipleChoiceEntity> info = examinationAndMultipleChoiceMapper.selectList(Wrappers.<ExaminationAndMultipleChoiceEntity>lambdaQuery().eq(ExaminationAndMultipleChoiceEntity::getExaminationId, examId));
        List<MultipleChoiceEntity> hadMultipleChoiceEntity = new ArrayList<>();
        for (int i = 0; i < info.size(); i++) {
            hadMultipleChoiceEntity.add(i, multipleChoiceMapper.selectById(info.get(i).getMultipleChoiceId()));
        }
        for (int i = 0; i < hadMultipleChoiceEntity.size(); i++) {
            for (int j = 0; j < allMultipleChoiceEntity.size(); j++) {
                if (Objects.equals(hadMultipleChoiceEntity.get(i).getMultipleChoiceId(), allMultipleChoiceEntity.get(j).getMultipleChoiceId())) {
                    allMultipleChoiceEntity.remove(allMultipleChoiceEntity.get(j));
                }
            }
        }
        return allMultipleChoiceEntity;
    }

    @PostMapping("/editChoiceById")//修改选择题信息并返回新数据
    public List<MultipleChoiceEntity> editChoiceById(@RequestBody MultipleChoiceEntity multipleChoiceEntity) {
        multipleChoiceMapper.updateById(multipleChoiceEntity);
        return multipleChoiceMapper.selectList(null);
    }

    @GetMapping("/deleteChoiceById/{choiceId}")//删除选择题信息并返回新数据
    public List<MultipleChoiceEntity> deleteChoiceById(@PathVariable String choiceId) {
        multipleChoiceMapper.deleteById(choiceId);
        return multipleChoiceMapper.selectList(null);
    }

    @PostMapping("/addChoice")//新增选择题并返回新数据
    public List<MultipleChoiceEntity> addChoice(@RequestBody MultipleChoiceEntity multipleChoiceEntity) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        multipleChoiceEntity.setMultipleChoiceId(id);
        multipleChoiceMapper.insert(multipleChoiceEntity);
        return multipleChoiceMapper.selectList(null);
    }

    @GetMapping("/findChoiceAll/{search}")
    public List<MultipleChoiceEntity> findChoiceAll(@PathVariable String search) {
        return multipleChoiceMapper.selectList(new QueryWrapper<MultipleChoiceEntity>().like("multiple_choice_describe", search)
                .or().like("option1", search).or().like("option2", search).or().like("option3", search)
                .or().like("option4", search));
    }
}
