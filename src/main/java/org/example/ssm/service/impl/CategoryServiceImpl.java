package org.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.entity.Category;
import org.example.ssm.service.CategoryService;
import org.example.ssm.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author chen3
* @description 针对表【category】的数据库操作Service实现
* @createDate 2024-09-04 15:30:52
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




