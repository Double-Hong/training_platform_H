package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.ScoreEntity;
import com.example.training_platform_h.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Double-Hong
 * @since 2023-01-30 21:28:52
 */
@RestController
@RequestMapping("/score-entity")
public class ScoreController {

    @Autowired
    ScoreMapper scoreMapper;

    @GetMapping("getScoreByEidAndPersonInfoId/{eid},{pid}")
    public Number getScoreByEidAndPersonInfoId(@PathVariable String eid, @PathVariable String pid) {
        if (scoreMapper.selectOne(Wrappers.<ScoreEntity>lambdaQuery().eq(ScoreEntity::getExaminationId, eid).eq(ScoreEntity::getPersonInfoId, pid)) == null)
            return -1;
        else {
            return scoreMapper.selectOne(Wrappers.<ScoreEntity>lambdaQuery().eq(ScoreEntity::getExaminationId, eid).eq(ScoreEntity::getPersonInfoId, pid)).getScore();
        }
    }

    @PostMapping("setScoreByEidAndPersonInfo")
    public int setScoreByEidAndPersonInfoId(@RequestBody ScoreEntity score) {
        scoreMapper.insert(score);
//            ScoreEntity result=scoreMapper.selectById(score.getPersonInfoId());
//              result.setScore(score.getScore());
        if (scoreMapper.selectOne(Wrappers.<ScoreEntity>lambdaQuery().eq(ScoreEntity::getExaminationId, score.getExaminationId()).eq(ScoreEntity::getPersonInfoId, score.getPersonInfoId())).getScore() != null) {
            return 1;
        } else return 0;
    }
}
