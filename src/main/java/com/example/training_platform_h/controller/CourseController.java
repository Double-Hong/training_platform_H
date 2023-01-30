package com.example.training_platform_h.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.training_platform_h.entity.CourseEntity;
import com.example.training_platform_h.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Double-Hong and My-way
 * @since 2023-01-15 11:31:10
 */
@RestController
@RequestMapping("/course-entity")
public class CourseController {

    @Autowired
    CourseMapper courseMapper;

    @GetMapping("/getCourseByOrganizationId/{OrganizationId}")
    public List<CourseEntity> getCourseByOrganizationId(@PathVariable String OrganizationId){
        System.out.println(courseMapper.selectList(new QueryWrapper<CourseEntity>().eq("org_id",OrganizationId)));
        return courseMapper.selectList(new QueryWrapper<CourseEntity>().eq("org_id",OrganizationId));
    }
}
