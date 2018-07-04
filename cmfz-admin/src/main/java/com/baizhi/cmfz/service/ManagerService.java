package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Manager;

/**
 * Created by zzf_PC on 2018/7/4.
 * @Description managerService接口
 * @Author  赵云溪
 * @Time    2018年7月4日 16点12分
 */
public interface ManagerService {
    public Manager queryManagerByNameAndPassword(String managerName , String managerPassword);
}
