package org.example.ssm.exception;

import org.example.ssm.entity.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    // 全局异常处理
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "服务器异常");
    }

}
