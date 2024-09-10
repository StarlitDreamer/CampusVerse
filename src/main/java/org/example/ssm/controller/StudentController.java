package org.example.ssm.controller;

import org.example.ssm.entity.Result;
import org.example.ssm.entity.Student;
import org.example.ssm.service.StudentService;
import org.example.ssm.utils.JwtUtil;
import org.example.ssm.utils.MD5Tool;
import org.example.ssm.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Pattern;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
@Validated
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        Student student = studentService.findByStudentName(username);
        if (student == null) {
            studentService.register(username, password);
            return Result.success();
        } else {
            return Result.error("用户名已存在");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        Student student = studentService.findByStudentName(username);
        if (student == null) {
            return Result.error("用户名不存在");
        } else {
            if (student.getPassword().equals(MD5Tool.generateMD5(password))) {
                // 登录成功，生成jwt
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", student.getId());
                claims.put("username", student.getUsername());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            } else {
                return Result.error("密码错误");
            }
        }
    }

    @GetMapping("/StudentInfo")
    public Result<Student> getStudentInfo(/*@RequestHeader(name="Authorization") String token*/) {
 /*       Map<String, Object> map = JwtUtil.parseToken(token);
        String username =(String) map.get("username");*/

        Map<String, Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        Student student = studentService.findByStudentName(username);
        return Result.success(student);
    }

    @PutMapping("/update")
    public Result update(@Validated @RequestBody Student student) {
        studentService.update(student);
        return Result.success();
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam String avatarUrl) {
        studentService.updateAvatar(avatarUrl);
        return Result.success();
    }
}
