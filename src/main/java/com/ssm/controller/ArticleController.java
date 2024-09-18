package com.ssm.controller;

import com.ssm.entity.Article;
import com.ssm.entity.PageBean;
import com.ssm.entity.Result;
import com.ssm.mapper.ArticleMapper;
import com.ssm.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleMapper articleMapper;

    @PostMapping
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(HttpServletRequest request,
                                          Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) Integer categoryId,
                                          @RequestParam(required = false) String state
    ) {
        String authorization = request.getHeader("Authorization");
        System.out.println(authorization);
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId, state);
        return Result.success(pb);
    }
}
