package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.Picture;

import java.util.Map;

/**
 * Created by zzf_PC on 2018/7/5.
 */
public interface PictureService {
    public Map<String , Object> queryAllPictureByPage(Integer nowPage , Integer pageSize);
}
