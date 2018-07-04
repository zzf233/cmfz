package com.baizhi.test;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zzf_PC on 2018/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @Test
    public void test1(){
        Manager manager = managerService.queryManagerByNameAndPassword("赵云溪", "123123");
        System.out.println(manager);
    }
}
