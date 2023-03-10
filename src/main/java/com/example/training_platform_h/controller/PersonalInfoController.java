package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.training_platform_h.entity.PersonalInfoEntity;
import com.example.training_platform_h.mapper.PersonalInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
                .eq("username", personalInfo.getUsername()).eq("password", personalInfo.getPassword()).eq("user_type", personalInfo.getUserType()));

        if (lists.size() != 0) {
            return 1;
        } else {
            return 0;
        }

    }
//  @PostMapping("/zhuceUser")//注册用户
//    public int zhuceUser(@RequestBody PersonalInfoEntity personinfo){
//      UUID uuid = UUID.randomUUID();
//      String id =uuid.toString();
//      personinfo.setId(id);
//      personinfo.setOrganizationId(null);
//      if (personinfo.getUsername()==null||personinfo.getPassword()==null){
//          return -1;
//      }
//      return personalInfoMapper.insert(personinfo);
//  }
//  @GetMapping("/FindUserByUserName/{username}")//用username找出全部user信息
//    public PersonalInfoEntity FindUserByUserName(@PathVariable String username){
//      return personalInfoMapper.selectOne(Wrappers.<PersonalInfoEntity>lambdaQuery().eq(PersonalInfoEntity::getUsername,username));
//
//  }

    @PostMapping("/zhuceUser")//注册用户
    public int zhuceUser(@RequestBody PersonalInfoEntity personinfo) {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        personinfo.setId(id);
        personinfo.setOrganizationId(null);
        if (personinfo.getUsername() == null || personinfo.getPassword() == null) {
            return -1;
        }
        return personalInfoMapper.insert(personinfo);
    }

    @GetMapping("/getPersonalInfo/{id}")//通过id得到学员的全部信息
    public PersonalInfoEntity getPersonalInfo(@PathVariable String id) {
        return personalInfoMapper.selectById(id);
    }

    @PostMapping("/checkOldPassword")//修改密码检查原密码是否正确
    public int checkOldPassword(@RequestBody PersonalInfoEntity personalInfo) {
        List<PersonalInfoEntity> lists = personalInfoMapper.selectList(new QueryWrapper<PersonalInfoEntity>().eq("id", personalInfo.getId())
                .eq("password", personalInfo.getPassword()));
        if (lists.size() != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @PostMapping("/modifyPassword")//修改密码
    public int modifyPassword(@RequestBody PersonalInfoEntity personalInfo) {
        PersonalInfoEntity modify = personalInfoMapper.selectById(personalInfo.getId());
        modify.setPassword(personalInfo.getPassword());
        return personalInfoMapper.updateById(modify);
    }

    @GetMapping("/FindUserByUserName/{username}")//用username找出全部user信息
    public PersonalInfoEntity FindUserByUserName(@PathVariable String username) {
        return personalInfoMapper.selectOne(Wrappers.<PersonalInfoEntity>lambdaQuery().eq(PersonalInfoEntity::getUsername, username));

    }

    @PostMapping("/modifyInfoById")//机构管理员修改个人信息
    public int modifyInfoById(@RequestBody PersonalInfoEntity personalInfo) {
        return personalInfoMapper.updateById(personalInfo);
    }

    @GetMapping("/getInfoByOrganizationId/{organizationId},{type}")//通过机构ID获取机构管理员信息
    public List<PersonalInfoEntity> getInfoByOrganizationId(@PathVariable String organizationId, @PathVariable String type) {
        return personalInfoMapper.selectList(new QueryWrapper<PersonalInfoEntity>().eq("organization_id", organizationId).eq("user_type", type));
    }

    @GetMapping("/getStudentsInfoByOrganizationId/{organizationId}")//通过机构ID获取学员信息
    public List<PersonalInfoEntity> getStudentsInfoByOrganizationId(@PathVariable String organizationId) {
        return personalInfoMapper.selectList(new QueryWrapper<PersonalInfoEntity>().eq("organization_id", organizationId).eq("user_type", 3));
    }

    @GetMapping("/deleteStudentById/{studentId}")//删除学员
    public int deleteStudentById(@PathVariable String studentId) {
        return personalInfoMapper.deleteById(studentId);
    }

    @GetMapping("/resetPasswordById/{id}")//重置密码
    public int resetPasswordById(@PathVariable String id) {
        PersonalInfoEntity personalInfo = personalInfoMapper.selectOne(new QueryWrapper<PersonalInfoEntity>().eq("id", id));
        personalInfo.setPassword("123456");
        return personalInfoMapper.updateById(personalInfo);
    }

    @GetMapping("/findStudent/{search}/{orgId}")//查找学员
    public List<PersonalInfoEntity> findStudent(@PathVariable String orgId, @PathVariable String search) {
        return personalInfoMapper.selectList(new QueryWrapper<PersonalInfoEntity>().eq("organization_id", orgId).and(i -> i.like("username", search).or().like("name", search)));
    }

    @GetMapping("getAlladministratorByType/{type}")
    public List<PersonalInfoEntity> getAlladministratorByType(@PathVariable int type) {
        return personalInfoMapper.selectList(Wrappers.<PersonalInfoEntity>lambdaQuery().eq(PersonalInfoEntity::getUserType, type));
    }

    @GetMapping("findadministrator/{username},{type}")
    public List<PersonalInfoEntity> findadministrator(@PathVariable String username, @PathVariable int type) {
        return personalInfoMapper.selectList(Wrappers.<PersonalInfoEntity>lambdaQuery().eq(PersonalInfoEntity::getUserType, type).like(PersonalInfoEntity::getUsername, username));
    }
}

