package com.example.training_platform_h;

import com.example.training_platform_h.entity.OrganizationInfoEntity;
import com.example.training_platform_h.entity.PersonalInfoEntity;
import com.example.training_platform_h.mapper.OrganizationInfoMapper;
import com.example.training_platform_h.mapper.PersonalInfoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class TrainingPlatformHApplicationTests {

    @Autowired
    PersonalInfoMapper personalInfoMapper;

    @Autowired
    OrganizationInfoMapper organizationInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        UUID uuid = UUID.randomUUID();
        String id = uuid.toString();
        System.out.println(id);
        System.out.println();
    }

}
