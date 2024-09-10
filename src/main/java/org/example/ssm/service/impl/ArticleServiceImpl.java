package org.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.entity.Article;
import org.example.ssm.service.ArticleService;
import org.example.ssm.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
* @author chen3
* @description 针对表【article】的数据库操作Service实现
* @createDate 2024-09-04 15:30:24
*/
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService{

}




