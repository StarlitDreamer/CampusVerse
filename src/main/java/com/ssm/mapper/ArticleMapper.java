package com.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import com.ssm.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author chen3
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-09-04 15:30:24
* @Entity org.example.ssm.entity.Article
*/
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    @Insert("insert into article(title,content,cover_img,state,category_id,create_user,create_time,update_time) " +
            "values(#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},#{createTime},#{updateTime})")
    void add(Article article);

    List<Article> list(@Param("userId")Integer userId, @Param("categoryId") Integer categoryId,@Param("state") String state);
}