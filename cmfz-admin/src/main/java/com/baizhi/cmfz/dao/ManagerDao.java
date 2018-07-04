package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Manager;
import org.apache.ibatis.annotations.Param;

/**
 * Created by zzf_PC on 2018/7/4.
 * @Description managerDao接口
 * @Author  赵云溪
 * @Time    2018年7月4日 16点11分
 */
public interface ManagerDao {
    /**
     * @Description 通过用户名查询用户信息
     * @Author      赵云溪
     * @Time        2018年7月4日 16点11分
     * @Param       managerName:用户名
     * @Exception   无
     */
    public Manager findManagerByName(@Param("managerName") String managerName);
}
