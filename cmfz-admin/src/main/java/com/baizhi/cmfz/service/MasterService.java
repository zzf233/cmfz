package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Master;

import java.util.List;
import java.util.Map;

/**
 * Created by zzf_PC on 2018/7/5.
 */
public interface MasterService {
    public Map<String , Object> queryAllMasterByPage(Integer nowPage, Integer pageSize);
    public void addMaster(Master master);
    public Map<String , Object> queryAllMasterByFuzzy(Integer nowPage, Integer pageSize , String condition , String value);
    public void addBatch(List<Master> gurus);
    public List<Master> queryAllMaster();
}
