package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Picture;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zzf_PC on 2018/7/5.
 */
public interface PictureDao {
    public List<Picture> findAllPictureByPage(@Param("begin") Integer begin , @Param("end") Integer end);
    public int count();

    public void insertPicture(Picture picture);

    public Picture findPictureById(@Param("pictureId") String pictureId);

    public void updatePicture(Picture picture);
}
