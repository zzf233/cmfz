package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by zzf_PC on 2018/7/10.
 */
public interface LogService {
    public void appendLog(Log log);

    public Map<String , Object> queryAllLogByPage(Integer nowPage , Integer pageSize);
}
