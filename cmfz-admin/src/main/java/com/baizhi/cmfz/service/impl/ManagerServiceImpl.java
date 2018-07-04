package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ManagerDao;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zzf_PC on 2018/7/4.
 * @Description managerService接口的实现
 * @Author  赵云溪
 * @Time    2018年7月4日 16点12分
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{

    @Autowired(required = false)
    private ManagerDao managerDao;

    /**
     * @Description 通过用户名和用户密码实现登陆操作
     * @Author      赵云溪
     * @Time        2018年7月4日 16点12分
     * @Param       managerName:用户名     managerPassword:用户密码
     * @Exception   无
     */
    @Override
    public Manager queryManagerByNameAndPassword(String managerName, String managerPassword) {
        Manager manager = managerDao.findManagerByName(managerName);
        if (manager != null && manager.getManagerPassword().equals(DigestUtils.sha256Hex(managerPassword + manager.getManagerSalt()))){
            return manager;
        }
        return null;
    }
}
