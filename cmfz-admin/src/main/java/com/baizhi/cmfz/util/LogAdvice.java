package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Log;
import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by zzf_PC on 2018/7/10.
 */
@Aspect
public class LogAdvice {

    @Autowired
    private LogService logService;


    /**
     * 声明切入点表达式
     */
    @Pointcut("execution(* com.baizhi.cmfz.service.impl.*.add*(..)) || execution(* com.baizhi.cmfz.service.impl.*.remove*(..)) || execution(* com.baizhi.cmfz.service.impl.*.modify*(..))")
    public void pc(){}

    @Around("pc()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("---------------环绕前通知---------------");

        //创建日志对象
        Log log = new Log();

        //User
        HttpSession session = (HttpSession) RequestContextHolder.currentRequestAttributes().resolveReference(RequestAttributes.REFERENCE_SESSION);
        Manager mgr = (Manager)session.getAttribute("manager");
        log.setLogUser(mgr.getManagerName());

        //action
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        String methodName = method.getName();
        log.setLogAction(methodName);

        //Message
        Object[] args = proceedingJoinPoint.getArgs();
        String Message = "";
        for (Object arg : args) {
            Message+=arg;
        }
        log.setLogMessage(Message);


        //Resource
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        Integer index = className.lastIndexOf(".");
        className = className.substring(index);
        Integer sIndex = className.lastIndexOf("S");
        String Resource  = className.substring(1,sIndex);
        log.setLogResource(Resource);



        //调用传递   obj为返回值
        //result
        Object obj = null;
        String Result;
        try {
            obj = proceedingJoinPoint.proceed();
            Result = "Success";

        } catch (Throwable throwable) {
            Result = "Fail";
            throwable.printStackTrace();
        }

        log.setLogResult(Result);


        //存至数据库
        logService.appendLog(log);
        System.out.println("---------------环绕后通知---------------");

        return obj;   //return返回值
    }


}
