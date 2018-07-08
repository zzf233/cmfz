package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * Created by zzf_PC on 2018/7/8.
 */
public class Master {
    @Excel(name = "编号")
    private String masterId;

    @Excel(name = "法名")
    private String masterName;

    @Excel(name = "头像")
    private String masterPhoto;

    @Excel(name = "描述信息")
    private String masterSummar;

    @Override
    public String toString() {
        return "Master{" +
                "masterId='" + masterId + '\'' +
                ", masterName='" + masterName + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterSummar='" + masterSummar + '\'' +
                '}';
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterSummar() {
        return masterSummar;
    }

    public void setMasterSummar(String masterSummar) {
        this.masterSummar = masterSummar;
    }
}
