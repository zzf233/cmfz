package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.dao.ArticleDao;
import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by zzf_PC on 2018/7/10.
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Autowired(required = false)
    private ArticleDao articleDao;

    @Override
    public void addArticle(Article article) {
        article.setArticleId(UUID.randomUUID().toString().replace("-" , ""));
        article.setArticleDate(new Date());
        article.setArticlePicture("1.jpg");
        articleDao.insertArticle(article);
    }
}
