package com.jqmanyi.fuyunfu.gameserver.palworld;

import jakarta.annotation.Resource;
import ltd.newbee.mall.NewBeeMallPlusApplication;
import ltd.newbee.mall.dao.AdminUserMapper;
import ltd.newbee.mall.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = NewBeeMallPlusApplication.class)
public class ExampleTest {
    @Resource
    private AdminUserMapper mapper;

    @Test
    public void testExample() {
        AdminUser adminUser = mapper.selectByPrimaryKey(1);
        System.out.println(adminUser.getNickName());
    }
}
