package com.baizhi.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.baizhi.cmfz.entity.Master;
import com.baizhi.cmfz.service.MasterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by zzf_PC on 2018/7/8.
 */
@Controller
@RequestMapping("/master")
public class MasterController {
    @Autowired
    private MasterService masterService;

    @RequestMapping("/queryAll")
    public @ResponseBody
    Map<String, Object> queryAllMasterByPage(@RequestParam("page") Integer nowPage, @RequestParam("rows") Integer pageSize, String condition, String value) {
        if (condition != null || value != null) {
            return masterService.queryAllMasterByFuzzy(nowPage, pageSize, condition, value);
        } else {
            return masterService.queryAllMasterByPage(nowPage, pageSize);
        }
    }

    @RequestMapping("addMaster")
    public void addMaster(MultipartFile multipartFile, String masterName, String masterSummar, HttpSession session) throws Exception {
        //1.获得文件夹名称
        String realPath = session.getServletContext().getRealPath("/");
        realPath = realPath.substring(0, realPath.lastIndexOf("\\"));
        String subString = realPath.substring(0, realPath.lastIndexOf("\\"));
        String uploadPath = subString + "\\upload";
        //2.生成UUID的唯一文件名
        String uuidName = UUID.randomUUID().toString().replace("-", "");
        //3.截取文件本身的后缀名
        String oldName = multipartFile.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        multipartFile.transferTo(new File(uploadPath + "/" + uuidName + suffix));
        Master master = new Master();
        master.setMasterName(masterName);
        master.setMasterPhoto(uuidName + suffix);
        master.setMasterSummar(masterSummar);
        masterService.addMaster(master);
    }

    @RequestMapping("/addBatch")
    public String addBatch(MultipartFile file){
        try {
            ImportParams importParams = new ImportParams();
            List<Master> masters = ExcelImportUtil.importExcel(file.getInputStream() , Master.class , importParams);
            masterService.addBatch(masters);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 注意事项：下载文件的时候不能使用异步请求 Ajax
     * dataType:支持json xml  不支持stream类型
     * @param response
     * @throws Exception
     */
    @RequestMapping("/export")
    public void exportExcel(HttpServletResponse response) throws Exception{
        List<Master> masters = masterService.queryAllMaster();
        //Excel文件
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("c118" , "上师信息表") , Master.class , masters);

        ServletOutputStream out = response.getOutputStream();

        //文件下载设置响应头
        //注意：响应头  默认使用的编码格式iso-8859-1   使用以下方式处理中文乱码
        String fileName = new String("上师信息的表.xls".getBytes() , "iso-8859-1");
        response.setHeader("content-disposition" , "attachment;fileName=" + fileName);
        //设置响应类型 text/html application
        response.setContentType("application/vnd.ms-excel");

        //导出 文件下载的方式
        workbook.write(out);
        out.close();
    }
}
