package com.baizhi.test;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.service.MenuService;
import com.baizhi.cmfz.service.PictureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by zzf_PC on 2018/7/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ManagerServiceTest {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private PictureService pictureService;

    @Test
    public void test1(){
        Manager manager = managerService.queryManagerByNameAndPassword("赵云溪", "123123");
        System.out.println(manager);
    }

    @Test
    public void test2(){
        List<Menu> menus = menuService.queryAllMenu();
        for (int i = 0 ; i < menus.size() ; i++){
            System.out.println(menus.get(i));
        }
    }

    @Test
    public void test3(){
        Map<String , Object> maps = pictureService.queryAllPictureByPage(1,2);
        System.out.println(maps);
    }
}
