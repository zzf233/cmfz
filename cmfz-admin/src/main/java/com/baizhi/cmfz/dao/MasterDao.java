package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Master;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzf_PC on 2018/7/8.
 */
public interface MasterDao {
    public List<Master> findAllMasterByPage(@Param("begin") Integer begin , @Param("end") Integer end);
    public int count();

    public void insertMaster(Master master);

    public List<Master> findAllMasterByFuzzy(@Param("begin") Integer begin , @Param("end") Integer end , @Param("condition") String condition , @Param("value") String value);
    public int countFuzzy(@Param("condition") String condition , @Param("value") String value);

    public void insertBatch(@Param("list") List<Master> list);

    public List<Master> findAllMaster();

}
