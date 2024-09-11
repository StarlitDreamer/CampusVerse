package org.example.ssm.controller;

import org.example.ssm.entity.Category;
import org.example.ssm.entity.Result;
import org.example.ssm.mapper.CategoryMapper;
import org.example.ssm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryMapper categoryMapper;

    @PostMapping
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        // 调用service层的方法添加分类
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }

    @GetMapping("/detail")
    public Result<Category> detail(Integer id) {
        Category category = categoryService.finById(id);
        return Result.success(category);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    @DeleteMapping()
    public Result delete(@RequestParam("id") Integer id) {
//        categoryService.delete(id);
        categoryMapper.deleteById(id);
        return Result.success();
    }
}
