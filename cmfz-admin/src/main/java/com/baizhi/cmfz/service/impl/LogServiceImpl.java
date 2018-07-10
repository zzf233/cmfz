package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.LogDao;
import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by zzf_PC on 2018/7/10.
 */
@Service
@Transactional
public class LogServiceImpl implements LogService{
    @Autowired(required = false)
    private LogDao logDao;
    @Override
    public void appendLog(Log log) {
        log.setLogId(UUID.randomUUID().toString().replace("-" , ""));
        log.setLogTime(new Date());
        logDao.insertLog(log);
    }

    @Override
    public Map<String, Object> queryAllLogByPage(Integer nowPage, Integer pageSize) {
        List<Log> logs = logDao.findAllLogByPage((nowPage-1)*pageSize , pageSize);
        int count = logDao.count();
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("total" , count);
        map.put("rows" , logs);
        return map;
    }
}
