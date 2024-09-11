package org.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.entity.Category;
import org.example.ssm.service.CategoryService;
import org.example.ssm.mapper.CategoryMapper;
import org.example.ssm.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
* @author chen3
* @description 针对表【category】的数据库操作Service实现
* @createDate 2024-09-04 15:30:52
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        Integer studentId = (Integer)map.get("id");
        category.setCreateUser(studentId);
        categoryMapper.add(category);
    }
}




