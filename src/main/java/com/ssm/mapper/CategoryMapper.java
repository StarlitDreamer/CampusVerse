package com.ssm.mapper;

import org.apache.ibatis.annotations.*;
import com.ssm.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author chen3
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-09-04 15:30:52
* @Entity org.example.ssm.entity.Category
*/
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time)" +
            "values(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime}) ")
    void add(Category category);

    @Select("select * from category where create_user = #{studentId}")
    List<Category> list(Integer studentId);

    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    @Update("update category set category_name = #{categoryName},category_alias = #{categoryAlias},update_time = #{updateTime} where id = #{id}")
    void update(Category category);
//
//    @Delete("delete from category where id = #{id}")
//    void delete(Integer id);
}




