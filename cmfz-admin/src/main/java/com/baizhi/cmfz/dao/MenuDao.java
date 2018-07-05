package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Menu;

import java.util.List;

/**
 * Created by zzf_PC on 2018/7/5.
 * @Description MasterDao接口
 * @Author  赵云溪
 * @Time    2018年7月5日 11点04分
 */
public interface MenuDao {
    /**
     * @Description 查询所有菜单栏信息
     * @Author      赵云溪
     * @Time        2018年7月5日 11点18分
     * @Param       无
     * @Exception   无
     */
    public List<Menu> findAllMenu();
}
