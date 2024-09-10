package org.example.ssm.controller;

import org.example.ssm.entity.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @RequestMapping("/list")
    public Result<String> list() {
        return Result.success("article");
    }
}
