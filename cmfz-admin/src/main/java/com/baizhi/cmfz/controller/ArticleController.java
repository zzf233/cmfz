package com.baizhi.cmfz.controller;

import com.baizhi.cmfz.entity.Article;
import com.baizhi.cmfz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zzf_PC on 2018/7/10.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/addArticle")
    public void addArticle(Article article , @RequestParam("articleName") String articleName , @RequestParam("masterId") String masterId , @RequestParam("articleStatus") String articleStatus){
        article.setArticleName(articleName);
        article.setMasterId(masterId);
        article.setArticleStatus(articleStatus);
        articleService.addArticle(article);
    }
}
