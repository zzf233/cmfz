package com.baizhi.cmfz.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zzf_PC on 2018/7/10.
 */
public class Log implements Serializable{
    private String logId;
    private String logUser;
    @JSONField(format = "yy-MM-dd hh:mm:ss")
    private Date logTime;
    private String logResource;
    private String logAction;
    private String logMessage;
    private String logResult;

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", logUser='" + logUser + '\'' +
                ", logTime=" + logTime +
                ", logResource='" + logResource + '\'' +
                ", logAction='" + logAction + '\'' +
                ", logMessage='" + logMessage + '\'' +
                ", logResult='" + logResult + '\'' +
                '}';
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getLogUser() {
        return logUser;
    }

    public void setLogUser(String logUser) {
        this.logUser = logUser;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getLogResource() {
        return logResource;
    }

    public void setLogResource(String logResource) {
        this.logResource = logResource;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getLogResult() {
        return logResult;
    }

    public void setLogResult(String logResult) {
        this.logResult = logResult;
    }
}
