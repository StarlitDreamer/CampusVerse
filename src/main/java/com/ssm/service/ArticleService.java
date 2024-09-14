package com.ssm.service;

import com.ssm.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssm.entity.PageBean;

/**
 * @author chen3
 * @description 针对表【article】的数据库操作Service
 * @createDate 2024-09-04 15:30:24
 */
public interface ArticleService extends IService<Article> {
    //新增文章
    void add(Article article);

    //条件分页列表查询
    PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);
}
