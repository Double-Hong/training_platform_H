package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.ExaminationEntity;
import com.example.training_platform_h.mapper.ExaminationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
@RequestMapping("/examination-entity")
public class ExaminationController {
    @Autowired
    ExaminationMapper examinationMapper;

    @GetMapping("/getAllExaminationByOrginzationId{id}")//根据机构id得到机构所有的考试信息
    public List<ExaminationEntity> getAllExaminationByOrginzationId(@PathVariable String id) {
        return examinationMapper.selectList(Wrappers.<ExaminationEntity>lambdaQuery().eq(ExaminationEntity::getOrganizationId, id));
    }

    @GetMapping("/getExaminationById/{id}")//通过eid获得考试的全部信息
    public ExaminationEntity getExaminationById(@PathVariable String id) {
        return examinationMapper.selectById(id);
    }

    @PostMapping("/modifyExamInfo")//通过id修改考试信息
    public int modifyExamInfo(@RequestBody ExaminationEntity examinationEntity) {
        return examinationMapper.updateById(examinationEntity);
    }

    @GetMapping("/deleteExamById/{examId}")//通过考试ID删除考试
    public int deleteExamById(@PathVariable String examId) {
        return examinationMapper.deleteById(examId);
    }

    @PostMapping("/addExam")//新增考试
    public int addExam(@RequestBody ExaminationEntity examinationEntity) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        examinationEntity.setExaminationId(id);
        return examinationMapper.insert(examinationEntity);
    }

    @GetMapping("/findExam/{search},{orgId}")//搜索考试
    public List<ExaminationEntity> findExam(@PathVariable String search, @PathVariable String orgId) {
        return examinationMapper.selectList(new QueryWrapper<ExaminationEntity>().like("examination_name", search).eq("organization_id", orgId));
    }
}
