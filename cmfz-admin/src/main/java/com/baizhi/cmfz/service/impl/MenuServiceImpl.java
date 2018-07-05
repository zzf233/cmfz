package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import com.baizhi.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zzf_PC on 2018/7/5.
 * @Description MenuService接口的实现
 * @Author  赵云溪
 * @Time    2018年7月5日 12点38分
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService{
    @Autowired(required = false)
    private MenuDao menuDao;
    /**
     * @Description 通过用户名和用户密码实现登陆操作
     * @Author      赵云溪
     * @Time        2018年7月5日 12点37分
     * @Param       无
     * @Exception   无
     */
    @Override
    @Transactional(propagation=Propagation.SUPPORTS , readOnly = true)
    public List<Menu> queryAllMenu() {
        return menuDao.findAllMenu();
    }
}
