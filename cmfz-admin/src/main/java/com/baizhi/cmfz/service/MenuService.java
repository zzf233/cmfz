package com.baizhi.cmfz.service;

import com.baizhi.cmfz.dao.MenuDao;
import com.baizhi.cmfz.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zzf_PC on 2018/7/5.
 */
public interface MenuService {
    public List<Menu> queryAllMenu();
}
