package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by zzf_PC on 2018/7/5.
 */
@Controller
@RequestMapping("/picture")
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping("/queryAll")
    public @ResponseBody Map<String , Object> queryAllPictureByPage(@RequestParam("page") Integer nowPage , @RequestParam("rows") Integer pageSize){
        System.out.println("----------------------+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return pictureService.queryAllPictureByPage(nowPage , pageSize);
    }

}
