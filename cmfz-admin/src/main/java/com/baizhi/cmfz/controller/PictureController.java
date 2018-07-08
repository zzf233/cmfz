package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Picture;
import com.baizhi.cmfz.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

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
        return pictureService.queryAllPictureByPage(nowPage , pageSize);
    }
    @RequestMapping("addPicture")
    public void addPicture(MultipartFile multipartFile ,String pictureDescription , String pictureStatus , HttpSession session) throws Exception{
        System.out.println(pictureDescription + pictureStatus);
        //1.获得文件夹名称
        String realPath = session.getServletContext().getRealPath("/");
        realPath = realPath.substring(0,realPath.lastIndexOf("\\"));
        String subString = realPath.substring(0,realPath.lastIndexOf("\\"));
        String uploadPath = subString + "\\upload";
        //2.生成UUID的唯一文件名
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        //3.截取文件本身的后缀名
        String oldName = multipartFile.getOriginalFilename();
        String suffix = oldName.substring( oldName.lastIndexOf(".") );
        multipartFile.transferTo(new File( uploadPath +"/"+ uuidName + suffix ));


        Picture picture = new Picture();
        picture.setPictureDescription(pictureDescription);
        picture.setPictureStatus(pictureStatus);
        picture.setPicturePath(uuidName + suffix);

        pictureService.addPicture(picture);
    }
}
