package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by zzf_PC on 2018/7/10.
 */
public class Article implements Serializable{
    private String articleId;
    private String articleName;
    private String articleContent;
    private Date articleDate;
    private String articlePicture;
    private String masterId;
    private String articleStatus;

    @Override
    public String toString() {
        return "Article{" +
                "articleId='" + articleId + '\'' +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate=" + articleDate +
                ", articlePicture='" + articlePicture + '\'' +
                ", masterId='" + masterId + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                '}';
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticlePicture() {
        return articlePicture;
    }

    public void setArticlePicture(String articlePicture) {
        this.articlePicture = articlePicture;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }
}
