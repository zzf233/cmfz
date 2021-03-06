package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.PictureDao;
import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzf_PC on 2018/7/5.
 */
@Service
@Transactional
public class PictureServiceImpl implements PictureService{
    @Autowired(required = false)
    private PictureDao pictureDao;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS , readOnly=true)
    public Map<String, Object> queryAllPictureByPage(Integer nowPage, Integer pageSize) {
        List<Picture> pictures = pictureDao.findAllPictureByPage((nowPage-1)*pageSize , pageSize);
        int count = pictureDao.count();
        Map<String , Object> map = new HashMap<String , Object>();
        map.put("total" , count);
        map.put("rows" , pictures);
        return map;
    }
}
