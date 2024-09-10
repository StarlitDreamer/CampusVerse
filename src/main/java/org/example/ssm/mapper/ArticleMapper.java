package org.example.ssm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.ssm.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author chen3
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-09-04 15:30:24
* @Entity org.example.ssm.entity.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}




