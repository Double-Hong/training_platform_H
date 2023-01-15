package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.training_platform_h.entity.PersonalInfoEntity;
import com.example.training_platform_h.mapper.PersonalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Double-Hong and My-way
 * @since 2023-01-15 11:31:10
 */
@RestController
@RequestMapping("/personal-info-entity")
public class PersonalInfoController {

    @Autowired
    PersonalInfoMapper personalInfoMapper;

    @PostMapping("/checkUser")//用户登录检查密码是否正确
    public int checkUser(@RequestBody PersonalInfoEntity personalInfo) {
        System.out.println(personalInfo);
        List<PersonalInfoEntity> lists = personalInfoMapper.selectList(new QueryWrapper<PersonalInfoEntity>()
                .eq("username", personalInfo.getUsername()).eq("password", personalInfo.getPassword()).eq("user_type",personalInfo.getUserType()));
        if (lists.size() != 0) {
            return 1;
        } else{
            return 0;
        }

    }

}
