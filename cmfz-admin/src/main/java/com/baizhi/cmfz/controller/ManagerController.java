package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.ManagerService;
import com.baizhi.cmfz.util.GetValidateCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Created by zzf_PC on 2018/7/4.
 * @Description managerController代码的编写
 * @Author  赵云溪
 * @Time    2018年7月4日 16点36分
 */

@Controller
@RequestMapping("/manager")
@SessionAttributes(value = {"manager" , "code"})
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    /**
     * @Description 登陆跳转
     * @Author      赵云溪
     * @Time        2018年7月4日 23点26分
     * @Param       无
     * @Exception   无
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login/login";
    }

    /**
     * @Description 跳转到主页面
     * @Author      赵云溪
     * @Time        2018年7月5日 10点11分
     * @Param       无
     * @Exception   无
     */
    @RequestMapping("/toMain")
    public String toMain(){
        return "main/main";
    }

    /**
     * @Description 登陆
     * @Author      赵云溪
     * @Time        2018年7月4日 16点47分
     * @Param       managerName:用户名     managerPassword:用户密码    enCode:用户输入的验证码     rememberPassword:是否记住密码    model:作用域
     * @Exception   cookie中文乱码处理异常
     */
    @RequestMapping("/login")
    public String login(String managerName , String managerPassword , String enCode , String rememberPassword , ModelMap model , HttpServletResponse response) throws Exception{
        System.out.println(managerName);
        Cookie cookieName = new Cookie("managerName" , URLEncoder.encode(managerName , "utf-8"));
        cookieName.setPath("/");
        response.addCookie(cookieName);
        if (enCode != null && enCode.equals(model.get("code"))){
            Manager manager = managerService.queryManagerByNameAndPassword(managerName , managerPassword);
            if (manager != null){
                if (rememberPassword != null){
                    Cookie cookiePassword = new Cookie("managerPassword" , URLEncoder.encode(managerPassword , "utf-8"));
                    cookiePassword.setPath("/");
                    response.addCookie(cookiePassword);
                }else {
                    Cookie cookiePassword = new Cookie("managerPassword",null);
                    cookiePassword.setMaxAge(0);
                    cookiePassword.setPath("/");
                    response.addCookie(cookiePassword);
                }
                model.addAttribute("manager" , manager);
                return "redirect:/manager/toMain";
            }
        }
        return "redirect:/manager/toLogin";
    }

    /**
     * @Description 获取验证码
     * @Author      赵云溪
     * @Time        2018年7月4日 23点28分
     * @Param       model:作用域
     * @Exception   输出流异常
     */
    @RequestMapping("/getCode")
    public void getCode(ModelMap model , HttpServletResponse response) throws Exception{
        GetValidateCodeUtils getValidateCodeUtils = new GetValidateCodeUtils(100,30,4,10);
        model.addAttribute("code" , getValidateCodeUtils.getCode());
        getValidateCodeUtils.write(response.getOutputStream());
    }

}
