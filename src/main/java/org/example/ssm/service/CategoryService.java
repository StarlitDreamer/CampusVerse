package org.example.ssm.service;

import org.example.ssm.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author chen3
 * @description 针对表【category】的数据库操作Service
 * @createDate 2024-09-04 15:30:52
 */
public interface CategoryService extends IService<Category> {
    //新增分类
    void add(Category category);

    //列表查询
    List<Category> list();

    //根据id查询
    Category finById(Integer id);

    void update(Category category);

    void delete(Integer id);
}
