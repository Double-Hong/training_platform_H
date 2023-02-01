package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.OrganizationInfoEntity;
import com.example.training_platform_h.entity.PersonalInfoEntity;
import com.example.training_platform_h.mapper.OrganizationInfoMapper;
import com.example.training_platform_h.mapper.PersonalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong
 * @since 2023-01-15 16:01:20
 */
@ResponseBody
@RestController
@RequestMapping("/organization-info-entity")
public class OrganizationInfoController {
    @Autowired
    PersonalInfoMapper personalInfoMapper;
    @Autowired
    OrganizationInfoMapper organizationInfoMapper;
    @PostMapping("/checkUser")//用户登录检查密码是否正确
    public String checkUser(@RequestBody PersonalInfoEntity personalInfo) {
        System.out.println(personalInfo);
        List<PersonalInfoEntity> lists = personalInfoMapper.selectList(new QueryWrapper<PersonalInfoEntity>()
                .eq("username", personalInfo.getUsername()).eq("password", personalInfo.getPassword()));
        if (lists.size() != 0) {
            return "登录成功!";
        } else{
            return "用户名或密码错误!";
        }

    }

    @GetMapping("/getNameById/{id}")//根据机构ID获取机构名
    public String getNameById(@PathVariable String id){
        System.out.println(id);
        System.out.println(organizationInfoMapper.selectById(id));
        System.out.println("ssss");
        return organizationInfoMapper.selectById(id).getName();
    }


    @GetMapping("/getOrganizationById/{id}")//通过机构id得到机构名字
    public String getOrganizationById(@PathVariable String id){
     OrganizationInfoEntity organizationInfo = organizationInfoMapper.selectOne(Wrappers.<OrganizationInfoEntity>lambdaQuery()
             .eq(OrganizationInfoEntity::getId,id));
        System.out.println(organizationInfo.getName());
        return organizationInfo.getName();
    }
    @PostMapping("/updateOrganizationinfo")//跟新机构信息
    public int updateOrganizationinfo(@RequestBody PersonalInfoEntity personalInfo){

            return  personalInfoMapper.updateById(personalInfo);
    }
    @PostMapping("/getAllOrganizationName")//得到所有的机构信息
    public List<OrganizationInfoEntity> getAllOrganizationName(){

        return organizationInfoMapper.selectList(null);
    }
   @GetMapping("/getOrganizationIdByname/{name}")//通过机构名字得到id
    public String getOrganizationIdByname (@PathVariable String name){
        return organizationInfoMapper.selectOne(Wrappers.<OrganizationInfoEntity>lambdaQuery().eq(OrganizationInfoEntity::getName,name)).getId();
   }
}
