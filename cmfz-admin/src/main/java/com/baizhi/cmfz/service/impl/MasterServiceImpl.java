package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.MasterDao;
import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.MasterService;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by zzf_PC on 2018/7/5.
 */
@Service
@Transactional
public class MasterServiceImpl implements MasterService {
    @Autowired(required = false)
    private MasterDao masterDao;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS , readOnly=true)
    public Map<String, Object> queryAllMasterByPage(Integer nowPage, Integer pageSize) {
        List<Master> masters = masterDao.findAllMasterByPage((nowPage-1)*pageSize , pageSize);
        int count = masterDao.count();
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("total" , count);
        map.put("rows" , masters);
        return map;
    }

    @Override
    public void addMaster(Master master) {
        master.setMasterId(UUID.randomUUID().toString().replace("-" , ""));
        masterDao.insertMaster(master);
    }

    @Override
    public Map<String, Object> queryAllMasterByFuzzy(Integer nowPage, Integer pageSize, String condition, String value) {
        List<Master> masters = masterDao.findAllMasterByFuzzy((nowPage-1)*pageSize , pageSize , condition , value);
        int countFuzzy = masterDao.countFuzzy(condition , value);
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("total" , countFuzzy);
        map.put("rows" , masters);
        return map;
    }

    @Override
    public void addBatch(List<Master> masters) {
        masterDao.insertBatch(masters);
    }

    @Override
    public List<Master> queryAllMaster() {
        return masterDao.findAllMaster();
    }
}
