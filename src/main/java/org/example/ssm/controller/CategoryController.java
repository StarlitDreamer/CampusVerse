package org.example.ssm.controller;

import org.example.ssm.entity.Category;
import org.example.ssm.entity.Result;
import org.example.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody Category category) {
        // 调用service层的方法添加分类
        categoryService.add(category);
        return Result.success();
    }
}
