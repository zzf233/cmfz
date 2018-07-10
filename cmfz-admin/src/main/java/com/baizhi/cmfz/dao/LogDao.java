package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Log;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzf_PC on 2018/7/10.
 */
public interface LogDao {
    public void insertLog(Log log);
    public List<Log> findAllLogByPage(@Param("begin") Integer begin , @Param("end") Integer end);

    public int count();
}
