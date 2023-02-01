package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.TrainInfoEntity;
import com.example.training_platform_h.mapper.TrainInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong
 * @since 2023-01-29 11:41:26
 */
@RestController
@RequestMapping("/train-info-entity")
public class TrainInfoController {
      @Autowired

    TrainInfoMapper trainInfoMapper;

      @GetMapping("/getTrainInfoById/{id}")//id是机构id
    public TrainInfoEntity  getAllTrainInfoById (@PathVariable  String id){

          return trainInfoMapper.selectOne(Wrappers.<TrainInfoEntity>lambdaQuery().eq(TrainInfoEntity::getOrganizationId,id));
      }
}
