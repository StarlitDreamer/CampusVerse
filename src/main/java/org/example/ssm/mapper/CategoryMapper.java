package org.example.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.ssm.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}




